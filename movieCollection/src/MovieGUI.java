import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-26663
 * Date: 1/1/24
 *
 * MovieGUI class create the user interface and visual for a person to look for a movie, currently it will display movies at "random" each time the application opens
 * and has a genre search feature which allows the user to type a genre and the application will display all those movies that hold that genre. The user can also
 * click on any movie image bring up information that was stored into the movie collection list that downloaded from the database. This means for now all code in here just
 * Manipulates information for the movies list that holds all the movie objects
 */

public class MovieGUI extends JFrame
{

    int scrollPositionTop=125;
    int scrollPositionBottom=575;
    public MovieGUI()
    {

        MovieCollection movieCollection = new MovieCollection();// creating the movieCollection here to pass on to buttonMakermethods
        final int movieId=1;// so it always starts at one
        int max=movieCollection.maxNumberOfMoviesInDB();
        movieCollection.fetchMovieDataForJavaCollection(movieId,max);// loading the text file


        setTitle("My Movie Collection");
        setSize(1400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1400, 1000));
        setContentPane(layeredPane);
        layeredPane.setLayout(null);

        // Load and set background image
        ImageIcon backgroundImage = new ImageIcon("resources/movieImages/Streaming background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1400, 1000);
        layeredPane.add(backgroundLabel, Integer.valueOf(JLayeredPane.DEFAULT_LAYER));


        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(5, 5, 1388, 960);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false); // Make panel transparent to show the background

        layeredPane.add(mainPanel, Integer.valueOf(JLayeredPane.PALETTE_LAYER));

        JButton searchButton = new JButton();
        ImageIcon buttonIcon = new ImageIcon("resources/movieImages/search_Icon.png");
        searchButton.setIcon(buttonIcon);
        searchButton.setLayout(null);
        searchButton.setBounds(1300,6,75,50);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setContentAreaFilled(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run()
                    {
                        String searchTerm=searchTerm(movieCollection);
                        searchResultWindow(movieCollection,searchTerm);
                    }
                });}

        });
        mainPanel.add(searchButton);

        JPanel moviePanel1 = new JPanel();
        //moviePanel1.setBounds(6, 125, 1388, 350);
        moviePanel1.setPreferredSize(new Dimension(1931,303+12));// THIS Was needed for the scrolling enough space to fit all the buttons that can't be seen + the box height
        moviePanel1.setLayout(null);
        moviePanel1.setOpaque(false);
        //mainPanel.add(moviePanel1);will be added in the scroll method
        movieButtonMakerTop(mainPanel,moviePanel1,movieCollection);



        JPanel moviePanel2 = new JPanel();
        //moviePanel2.setBounds(6, 575, 1388, 350);
        moviePanel2.setPreferredSize(new Dimension(1931,303+12));// THIS Was needed for the scrolling enough space to fit all the buttons that can't be seen + the box height
        moviePanel2.setLayout(null);
        moviePanel2.setOpaque(false);
        //mainPanel.add(moviePanel2); will be added in the scroll method
        movieButtonMakerBottom(mainPanel,moviePanel2,movieCollection);

        //searchResultWindow(movieCollection);


        setVisible(true);
    }

    public String searchTerm(MovieCollection movieCollection) {
        String searchTerm;
        boolean isGenrePresent = false;

        do {
            searchTerm = JOptionPane.showInputDialog("Enter the name of a genre you would like to watch:");
            wordCheck(searchTerm); // checks for numbers

            if (searchTerm != null && !searchTerm.trim().isEmpty()) {
                searchTerm = searchTerm.trim(); // Remove leading and trailing spaces
                searchTerm = searchTerm.substring(0, 1).toUpperCase() + searchTerm.substring(1).toLowerCase(); // Capitalize first letter

                // Check if the genre is present in the collection
                isGenrePresent = movieCollection.genreMovieHashMap.containsKey(searchTerm);
                if (!isGenrePresent) {
                    JOptionPane.showMessageDialog(null, "Genre not found. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid genre entered. Please try again.");
            }
        } while (!isGenrePresent);

        return searchTerm;
    }

    public static boolean wordCheck(String test) // this test is different used to check if letter are entered
    {
        boolean letter= false;

        for (int i = 0; i < test.length(); i++) {
            char ch1 = test.charAt(i);
            if (!Character.isAlphabetic(ch1)) {
                letter = false;
                JOptionPane.showMessageDialog(null, "Enter a valid word");
                break;
            }

            else if (Character.isAlphabetic(ch1)) {
                letter = true;
            }
        } // for loop end
        return letter;
    }

    public void movieButtonMakerTop(JPanel mainPanel,JPanel moviePanel,MovieCollection movieCollection) //reason for 2 button makers is just for positioning of the top and bottom
    {

        buttonMakerForMainFrame(moviePanel,movieCollection);
        scrollFeatureAddition(mainPanel,moviePanel,scrollPositionTop);


    }



    public void movieButtonMakerBottom(JPanel mainPanel,JPanel moviePanel,MovieCollection movieCollection)
    {
        buttonMakerForMainFrame(moviePanel,movieCollection);
        scrollFeatureAddition(mainPanel,moviePanel,scrollPositionBottom);

    }

    public void buttonMakerForMainFrame(JPanel moviePanel,MovieCollection movieCollection)
    {
        int counter =randomNumberGenerator(movieCollection);
        int buttonSpacer=275;
        for (int i = 1; i <= 7; i++)
        {
            final int currentCounter=counter;
            JButton button = new JButton();
            ImageIcon buttonIcon = new ImageIcon(movieCollection.movies.get(currentCounter).getImagePath());
            button.setIcon(buttonIcon);
            // Optional: Make the button's content area and border invisible (comment out if not desired)
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            openNewWindow(movieCollection,currentCounter);
                        }
                    });}

            });


            if(i>=2)
            {
                button.setBounds(buttonSpacer*(i-1),6,240,303);
                moviePanel.add(button);
            }

            else
            {
                button.setBounds(6,6,240,303);
                moviePanel.add(button);
            }

            counter++;
        }//end of forward loop
    }

    /*
     * searchResultWindow this method will find the movies that have a certain genre related to that movie and pull up all the movies that have that genre
     * so if you type in comedy you will get all the movies that have that label on that movie. THE ONLY specific genre that does work but should is sci-fi due to the hypen
     * so that needs to be fixed
     */

    public void searchResultWindow(MovieCollection movieCollection,String searchTerm)
    {

        JPanel movieResultPanel = new JPanel(); // Create a new panel to hold buttons
        movieResultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Use FlowLayout with left alignment and gaps
        //layeredPaneNewWindow.add(movieResultPanel, Integer.valueOf(JLayeredPane.PALETTE_LAYER));

        int buttonSpacer=275;

        List<Integer>moviesFound=movieCollection.userGenreSearch(searchTerm);
        int resultsFound =moviesFound.size();

        for (int i = 0; i < resultsFound; i++)
        {
            int indexPosition=moviesFound.get(i);

            JButton button = new JButton();
            ImageIcon buttonIcon = new ImageIcon(movieCollection.movies.get(indexPosition).getImagePath());
            button.setIcon(buttonIcon);
            // Optional: Make the button's content area and border invisible (comment out if not desired)
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            openNewWindow(movieCollection,indexPosition);
                        }
                    });}

            });


            if(i>=2)
            {
                button.setBounds(buttonSpacer*(i-1),6,240,303);
                movieResultPanel.add(button);
            }

            else
            {
                button.setBounds(6,6,240,303);
                movieResultPanel.add(button);
            }
        }// outer for loop

        // Set preferred size for the movieResultPanel to enable horizontal scrollbar
        Dimension preferredSize = new Dimension(240*(resultsFound), 265);
        movieResultPanel.setPreferredSize(preferredSize);

        JScrollPane scrollPane = new JScrollPane(movieResultPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Disable vertical scrollbar
        scrollPane.setVisible(true);

        // Assuming you have some JFrame where you want to add this scroll pane
        JFrame frame = new JFrame(searchTerm);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(scrollPane); // Add the scroll pane to the frame
        frame.pack();
        frame.setVisible(true);




    }

    public int randomNumberGenerator(MovieCollection movieCollection)
    {
        int min=1;
        int max=movieCollection.movies.size();

        Random random = new Random();
        int randomNumber = random.nextInt(max);

        if(randomNumber>(max-7))
        {
            randomNumber-=7;
        }


        return randomNumber;
    }




    public void scrollFeatureAddition(JPanel mainPanel,JPanel moviePanel,int scrollPosition) // Position of this scroll determines the position of the moviePanel based on who the first line of code is written, allows to have two scrolls on separate panels
    {
        // JScrollPane that makes the buttonsPanel scrollable
        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setVisible(true);
        // Adjust the preferred size of the scrollable area to take about half the frame's height
        scrollPane.setPreferredSize(new Dimension(500, 50)); // Adjust width if needed
        scrollPane.setBounds(6, scrollPosition, 1388, 350); // Adjust these values as needed
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        mainPanel.add(scrollPane);
    }


    public void openNewWindow(MovieCollection movieCollection,int IndexPositionFromMovieCollection)
    {
        // Create a new JFrame instance for the new window
        JFrame newFrame = new JFrame(movieCollection.movies.get(IndexPositionFromMovieCollection).getTitle());
        newFrame.setSize(1000, 600);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setResizable(false);
        newFrame.setLocationRelativeTo(null);


        JLayeredPane layeredPaneNewWindow = new JLayeredPane();
        layeredPaneNewWindow.setPreferredSize(new Dimension(1000, 600));
        newFrame.setContentPane(layeredPaneNewWindow);
        layeredPaneNewWindow.setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("resources/movieImages/Streaming background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        layeredPaneNewWindow.add(backgroundLabel, Integer.valueOf(JLayeredPane.DEFAULT_LAYER));


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false); // Make panel transparent to show the background

        panel.setBounds(0, 0, 1000, 600);


        layeredPaneNewWindow.add(panel, Integer.valueOf(JLayeredPane.PALETTE_LAYER));

        // Load the movie image and create a label for it
        ImageIcon movieImage = new ImageIcon(movieCollection.movies.get(IndexPositionFromMovieCollection).getImagePath());
        JLabel movieImageLabel = new JLabel(movieImage);
        // Set the bounds of the movieImageLabel to fit the panel
        // Here, I'm assuming the image should fill the entire panel, adjust as needed
        // Set the movie image label bounds
        movieImageLabel.setBounds(0, 0, 260, 360);
        panel.add(movieImageLabel);


        JTextArea movieDescriptionText = new JTextArea("Description\n"+movieCollection.movies.get(IndexPositionFromMovieCollection).getDescription());
        movieDescriptionText.setBounds(260, 90, 675, 125); // Adjust the size and position as needed
        movieDescriptionText.setOpaque(false); // Make the text area background transparent
        movieDescriptionText.setForeground(Color.WHITE); // Set the text color to white
        movieDescriptionText.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        movieDescriptionText.setWrapStyleWord(true); // Lines will be wrapped at word boundaries (whitespace) if they are too long
        movieDescriptionText.setLineWrap(true); // Lines will be wrapped if they are too long
        movieDescriptionText.setEditable(false); // Make it uneditable like a JLabel
        movieDescriptionText.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        panel.add(movieDescriptionText);

        String directors= String.join(", ", movieCollection.movies.get(IndexPositionFromMovieCollection).getDirector()); //test to use List String to just a string
        JLabel Directorslabel = new JLabel("Directors: "+directors);
        Directorslabel.setBounds(260, 115, 675, 125); // Adjust the size and position as needed
        Directorslabel.setOpaque(false); // Make the label background transparent
        Directorslabel.setForeground(Color.WHITE); // Set the text color to white
        Directorslabel.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        panel.add(Directorslabel);

        String writers= String.join(", ", movieCollection.movies.get(IndexPositionFromMovieCollection).getWriters()); //test to use List String to just a string
        JLabel WritesLabel = new JLabel("Writers: "+writers);
        WritesLabel.setBounds(260, 145, 675, 125); // Adjust the size and position as needed
        WritesLabel.setOpaque(false); // Make the label background transparent
        WritesLabel.setForeground(Color.WHITE); // Set the text color to white
        WritesLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        panel.add(WritesLabel);

        String actors= String.join(", ", movieCollection.movies.get(IndexPositionFromMovieCollection).getActors()); //test to use List String to just a string
        JLabel ActorsLabel = new JLabel("Actors: "+actors);
        ActorsLabel.setBounds(260, 175, 675, 125); // Adjust the size and position as needed
        ActorsLabel.setOpaque(false); // Make the label background transparent
        ActorsLabel.setForeground(Color.WHITE); // Set the text color to white
        ActorsLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        panel.add(ActorsLabel);

        String genres= String.join(", ", movieCollection.movies.get(IndexPositionFromMovieCollection).getGenre()); //test to use List String to just a string
        JLabel genreLabel = new JLabel("Genres: "+genres);
        genreLabel.setBounds(260, 205, 675, 125); // Adjust the size and position as needed
        genreLabel.setOpaque(false); // Make the label background transparent
        genreLabel.setForeground(Color.WHITE); // Set the text color to white
        genreLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        panel.add(genreLabel);

        String rating= String.valueOf(movieCollection.movies.get(IndexPositionFromMovieCollection).getRating()); //test to use List String to just a string
        JLabel ratingLabel = new JLabel("Rating: "+rating+"/10");
        ratingLabel.setBounds(260, 235, 675, 125); // Adjust the size and position as needed
        ratingLabel.setOpaque(false); // Make the label background transparent
        ratingLabel.setForeground(Color.WHITE); // Set the text color to white
        ratingLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Optional: Set the font style and size
        panel.add(ratingLabel);



        // Making the new window visible
        newFrame.setVisible(true);



    }


    public static void main(String[] args)
    {
        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(MovieGUI::new);

    }
}

