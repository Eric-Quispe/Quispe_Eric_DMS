import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Statement;


/**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-26663
 * Date: 1/1/24
 * MovieCollection class is responsible for updating the database, pulling information from the database into the movie objects to be stored into the movies list which will be
 * used by the GUI class to display all the information about that specific movie.
 * Currently, this section of the code has feature to load a text file that holds movie information into the database into the specific database tables, delete movies based on title or imagePath from the data base using the movie_ID that a movie is assigned from the database,
 * update the rating and description of a movie in the data base. These features have not currently been added to the GUI section of the code which means currently those feature can
 * only appear in the console for result.
 * my custom feature "search by genre" does work with the current GUI code so for the purposes of homework, this section the code has a main and some code to run all the requirement for the
 * homework and the Gui section has its own main as well in order to demonstrate the search feature (custom feature) of the application).
 */

public class MovieCollection
{
    /*
     * Final was added to the Movie List and the HashMap with the intentions of changing the values in the future do to removal or addition of a movie.
     * The same trick that was used to generate movie information a for loop final counter= counter.. consider the idea test later
     */
    int indexPosition=0;
    List<Movie> movies= new ArrayList<>(); // generic list to hold the collection and to avoid type casting later on
    HashMap<String,List<Integer>>genreMovieHashMap = new HashMap<>();



    public void displayMovies()
    {
        for (Movie movie: movies)
        {
            System.out.println(movie+"\n");
        }

    }

    /*
     *  hashMap that will combine with the loadMovieFile method, for now ( adjust need to be changed once the database is implemented.
     *  So in this case keys will be genres, and the index position of the movie in movieCollection List will be the result.
     *  example:  Comedy:1,2,4.16.19,27,40      ( the length of the result will be used to create buttons,windows and scroll to view what was found)
     *  CONSIDER REMAKING Map when a deletion occurs for the search to work
     *
     *  generateGenreIndexMap and userGenreSearch are both methods to Manipulate data from the movies list not the database
     */

    public void generateGenreIndexMap(List<String> genres, int movieIndex)
    {
        for (String genre : genres) {
            genreMovieHashMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(movieIndex);
        }
    }

    public List<Integer> userGenreSearch(String userInput)
    {
        return genreMovieHashMap.get(userInput);
    }

    /*
     * loadMovieFileAndAddToDatabase is the method used to download information from the text file into the data base.
     */

    public  void loadMovieFileAndAddToDatabase() {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password

        try (Connection connection = DriverManager.getConnection(url, user, password);
             BufferedReader reader = new BufferedReader(new FileReader("resources/movies.txt"))) {
            System.out.println("Connected to the database successfully");

            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the movie attributes from the line
                String[] movieAttributes = line.split("\\|");
                // Extract individual attributes
                String title = movieAttributes[0];
                List<String> genre = Arrays.asList(movieAttributes[1].split(";"));
                List<String> director = Arrays.asList(movieAttributes[2].split(";"));
                List<String> writers = Arrays.asList(movieAttributes[3].split(";"));
                List<String> actors = Arrays.asList(movieAttributes[4].split(";"));
                double rating = Double.parseDouble(movieAttributes[5]); // assigning rating
                String imagePath= movieAttributes[6];
                String description=movieAttributes[7];

                // Add movie to database (this method needs to handle inserting the movie and its relationships)
                int movieId = addingToMovieTable(title, imagePath, rating, description, connection);

                if (movieId == -1)
                {
                    // Movie already exists, no need to add genres, directors, writers, or actors ( skip the following code in the while loop)
                    continue;
                }
                List<Integer> genreIds = addingToGenresTable(genre, connection);
                List<Integer> directorIds =addingToDirectorsTable( director, connection);
                List<Integer> writerIds =addingToWritersTable(writers,connection);
                List<Integer> actorIds =addingToActorsTable(actors,connection);

                linkMovieToGenres(movieId,genreIds,connection);
                linkMovieToDirectors(movieId,directorIds,connection);
                linkMovieToWriters(movieId,writerIds,connection);
                linkMovieToActors(movieId,actorIds,connection);

                // Here, you'd also handle linking the movie to genres, directors, etc., in their linking tables
                // For example, linkMovieGenres(movieId, genreIds, connection);

                // Optionally add the movie to your in-memory list if needed
                // Movie movie = new Movie(title, genre, director, writers, actors, rating, imagePath, description);
                // movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /*
     * maxNumberOfMoviesInDB just gives the number of movies in the data base using the movie_Id since that is a primary key in the database only one of that movie should exist
     */
    public int maxNumberOfMoviesInDB()
    {
        int totalMovies = 0;
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password
        String query = "SELECT COUNT(movie_id) AS TotalMovies FROM Movies";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                totalMovies = rs.getInt("TotalMovies");
            }
            System.out.println("Total movies in the database: " + totalMovies);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return totalMovies;
    }

    /*
     * fetchMovieDataForJavaCollection method will get data from the database to create the movies list collection ( close the connection after to deal with less leaks and not waste a connection
     * resource since ideally it best to maintain Minimal interaction with the database.
     */
    public void fetchMovieDataForJavaCollection(int movieIdToFetch,int max)
    {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password



        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully");

            // SQL query to retrieve movie information for a specific movie_id
            String MovieInfoQuery = "SELECT m.movie_id, m.title, m.image_path, m.rating, m.description, " +
                    "GROUP_CONCAT(DISTINCT g.genre_name ORDER BY g.genre_name SEPARATOR ';') AS genres, " +
                    "GROUP_CONCAT(DISTINCT d.director_name ORDER BY d.director_name SEPARATOR ';') AS directors, " +
                    "GROUP_CONCAT(DISTINCT w.writer_name ORDER BY w.writer_name SEPARATOR ';') AS writers, " +
                    "GROUP_CONCAT(DISTINCT a.actor_name ORDER BY a.actor_name SEPARATOR ';') AS actors " +
                    "FROM Movies m " +
                    "LEFT JOIN Movie_Genres mg ON m.movie_id = mg.movie_id " +
                    "LEFT JOIN Genres g ON mg.genre_id = g.genre_id " +
                    "LEFT JOIN Movie_Directors md ON m.movie_id = md.movie_id " +
                    "LEFT JOIN Directors d ON md.director_id = d.director_id " +
                    "LEFT JOIN Movie_Writers mw ON m.movie_id = mw.movie_id " +
                    "LEFT JOIN Writers w ON mw.writer_id = w.writer_id " +
                    "LEFT JOIN Movie_Actors ma ON m.movie_id = ma.movie_id " +
                    "LEFT JOIN Actors a ON ma.actor_id = a.actor_id " +
                    "WHERE m.movie_id = ? " +
                    "GROUP BY m.movie_id, m.title, m.image_path, m.rating, m.description";

            while (movieIdToFetch<=max)

            {
                final int currentIndexPostion =indexPosition;
                try (PreparedStatement statement = connection.prepareStatement(MovieInfoQuery)) {
                    statement.setInt(1, movieIdToFetch); // Set the movie_id parameter
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int movieId = resultSet.getInt("movie_id");
                        String title = resultSet.getString("title");
                        String imagePath = resultSet.getString("image_path");
                        double rating = resultSet.getDouble("rating");
                        String description = resultSet.getString("description");
                        List<String> genres = Arrays.asList(resultSet.getString("genres").split(";"));
                        List<String> directors = Arrays.asList(resultSet.getString("directors").split(";"));
                        List<String> writers = Arrays.asList(resultSet.getString("writers").split(";"));
                        List<String> actors = Arrays.asList(resultSet.getString("actors").split(";"));


                        Movie movie = new Movie(movieId,title,genres,directors,writers,actors,rating,imagePath,description);
                        movies.add(movie);
                        generateGenreIndexMap(genres, currentIndexPostion);// hashmap based on the genres will be used to search movies based on genre
                        movieIdToFetch++;
                        indexPosition++;



                    } else {
                        System.out.println("No movie found with movie_id: " + movieIdToFetch);
                    }
                }
            }// end of while loop
            connection.close();
            System.out.println("Connection to the database closed successfully");
        }catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }


    }

    /*
     * findMovieIdByTitleFromDatabase and findMovieIdByImageFromDatabase will find the movie_Id based on the title or image name enter (image name still needs add the stand of resource location
     * like in main. This method will be updated later
     *
     * ideally i make the future way to delete movies from database more visual at least when it comes to the image path version for now its just text base like in the main example
     */

    public int  findMovieIdByTitleFromDatabase(String searchTerm)
    {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully");

            // SQL query to retrieve movie information for a specific movie_id
            String query = "SELECT movie_id FROM Movies WHERE title LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + searchTerm + "%");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt("movie_id");
                } else {
                    System.out.println("No movie found with title containing: " + searchTerm);
                    return -1; // Return a sentinel value indicating no match found
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return -1; // Return a sentinel value indicating an error occurred
        }
    }

    public int  findMovieIdByImageFromDatabase(String searchTerm)
    {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully");

            // SQL query to retrieve movie information for a specific movie_id
            String query = "SELECT movie_id FROM Movies WHERE image_path LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + searchTerm + "%");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt("movie_id");
                } else {
                    System.out.println("No movie found with image containing: " + searchTerm);
                    return -1; // Return a sentinel value indicating no match found
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return -1; // Return a sentinel value indicating an error occurred
        }
    }

    /*
     * using the information above finding movie_Id by using the title or image path, it will delete all the information related to that image.
     * This idea need some work still cause some actors, writers, and directors belong to different movies so future updates need to work on preventing deletion if more than movie,
     * database  may change
     */

    public void deleteMovieFromDatabase(int movieId,List<Movie> movies) {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully");
            connection.setAutoCommit(false);

            String[] deleteStatements = {
                    "DELETE FROM Movie_Actors WHERE movie_id = ?",
                    "DELETE FROM Movie_Directors WHERE movie_id = ?",
                    "DELETE FROM Movie_Writers WHERE movie_id = ?",
                    "DELETE FROM Movie_Genres WHERE movie_id = ?",
                    "DELETE FROM Movies WHERE movie_id = ?"
            };

            for (String sql : deleteStatements) {
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, movieId);
                    stmt.executeUpdate();
                }
            }
            connection.commit();
            movies.removeIf(movie -> movie.getMovieId() == movieId);
            System.out.println("Movie and all related data successfully deleted.");
        } catch (SQLException e) {
            System.out.println("Database operation error: " + e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    /*
     * updateDatabase will take a title string and update the rating, and description of a movie
     */
    public int updateDatabase(String searchTerm, double updateRating, String updateDescription) {
        String url = "jdbc:mysql://localhost:3306/db_movies"; // Database URL
        String user = "root"; // Database username
        String password = "04APR92!ehq"; // Database password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully");

            // SQL query to update rating and description in the Movies table
            String updateQuery = "UPDATE Movies SET rating = ?, description = ? WHERE title LIKE ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setDouble(1, updateRating);
                updateStatement.setString(2, updateDescription);
                updateStatement.setString(3, "%" + searchTerm + "%");

                // Execute the update statement
                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " rows updated successfully.");
                    return rowsAffected; // Return the number of rows updated
                } else {
                    System.out.println("No movie found with title containing: " + searchTerm);
                    return 0; // Return 0 indicating no matching movie found
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return -1; // Return -1 indicating an error occurred
        }
    }


    /*
     * all the remaining methods below are used in loadFileloadMovieFileAndAddToDatabase which just break down steps filling in the database tables,
     * so they fill the data for: Movies,actors,directors,writers tables and the linking method create the relationship tables for Movie_Id to those specific genre, Director, actors, writer that movie has
     */
    public int addingToMovieTable(String title, String imagePath, double rating, String description, Connection connection) throws SQLException
    {
        // Combined SQL query to check if a movie with the same title and image path already exists
        String query = "SELECT movie_id FROM Movies WHERE title = ? OR image_path = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, imagePath);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // If a movie with the same title or image path exists, return its ID
                return rs.getInt("movie_id");
            } else {
                // If no duplicate is found, insert the new movie
                String insertMovie = "INSERT INTO Movies (title, image_path, rating, description ) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertMovie, Statement.RETURN_GENERATED_KEYS)) {
                    insertStmt.setString(1, title);
                    insertStmt.setString(2, imagePath);
                    insertStmt.setDouble(3, rating);
                    insertStmt.setString(4, description);
                    insertStmt.executeUpdate();
                    ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        // Return the new movie ID
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }
        // If no duplicate is found and the new movie is inserted, return the new movie's ID
        // Placeholder for exception or error handling
        return -1; // Placeholder return value indicating failure or no insert
    }
    /*
     * This method add to the database
     */
    public List<Integer> addingToDirectorsTable(List<String> director, Connection connection) throws SQLException {
        List<Integer> directorIds = new ArrayList<>();
        for (String directorName : director) {
            String query = "SELECT director_id FROM Directors WHERE director_name = ?";
            int directorId = -1;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, directorName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    directorId = rs.getInt("director_id");
                } else {
                    String insertGenre = "INSERT INTO Directors (director_name) VALUES (?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertGenre, Statement.RETURN_GENERATED_KEYS)) {
                        insertStmt.setString(1, directorName);
                        insertStmt.executeUpdate();
                        ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            directorId = generatedKeys.getInt(1);
                            // directorIds.add(directorId);// added line
                        }
                    }
                }
            }
            if (directorId != -1) {
                directorIds.add(directorId);
            }
        }
        return directorIds; // Returns a list of genre IDs for the movie
    }

    public List<Integer> addingToGenresTable(List<String> genres, Connection connection) throws SQLException {
        List<Integer> genreIds = new ArrayList<>();
        for (String genreName : genres) {
            String query = "SELECT genre_id FROM Genres WHERE genre_name = ?";
            int genreId = -1;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, genreName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    genreId = rs.getInt("genre_id");
                } else {
                    String insertGenre = "INSERT INTO Genres (genre_name) VALUES (?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertGenre, Statement.RETURN_GENERATED_KEYS)) {
                        insertStmt.setString(1, genreName);
                        insertStmt.executeUpdate();
                        ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            genreId = generatedKeys.getInt(1);
                            // genreIds.add(genreId);// added line
                        }
                    }
                }
            }
            if (genreId != -1) {
                genreIds.add(genreId);
            }
        }
        return genreIds; // Returns a list of genre IDs for the movie
    }

    public List<Integer> addingToWritersTable(List<String> writers, Connection connection) throws SQLException {
        List<Integer> writersIds = new ArrayList<>();
        for (String writerNames : writers) {
            String query = "SELECT writer_id FROM Writers WHERE writer_name = ?";
            int writerId = -1;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, writerNames);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    writerId = rs.getInt("writer_id");
                } else {
                    String insertGenre = "INSERT INTO Writers (writer_name) VALUES (?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertGenre, Statement.RETURN_GENERATED_KEYS)) {
                        insertStmt.setString(1, writerNames);
                        insertStmt.executeUpdate();
                        ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            writerId = generatedKeys.getInt(1);
                            //  writersIds.add(writerId);// added line
                        }
                    }
                }
            }
            if (writerId != -1) {
                writersIds.add(writerId);
            }
        }
        return writersIds; // Returns a list of genre IDs for the movie
    }

    public List<Integer> addingToActorsTable(List<String> actors, Connection connection) throws SQLException {
        List<Integer> actorIds = new ArrayList<>();
        for (String actorNames : actors) {
            String query = "SELECT actor_id FROM Actors WHERE actor_name = ?";
            int genreId = -1;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, actorNames);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    genreId = rs.getInt("actor_id");
                } else {
                    String insertGenre = "INSERT INTO Actors (actor_name) VALUES (?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertGenre, Statement.RETURN_GENERATED_KEYS)) {
                        insertStmt.setString(1, actorNames);
                        insertStmt.executeUpdate();
                        ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            genreId = generatedKeys.getInt(1);
                            //  actorIds.add(genreId);// added line
                        }
                    }
                }
            }
            if (genreId != -1) {
                actorIds.add(genreId);
            }
        }
        return actorIds; // Returns a list of genre IDs for the movie
    }


    public void linkMovieToGenres(int movieId, List<Integer> genreIds, Connection connection) throws SQLException
    {
        String insertLink = "INSERT INTO Movie_Genres (movie_id, genre_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertLink)) {
            for (Integer genreId : genreIds) {
                insertStmt.setInt(1, movieId);
                insertStmt.setInt(2, genreId);
                insertStmt.executeUpdate();
            }
        }
    }

    public void linkMovieToDirectors(int movieId, List<Integer> directorIds, Connection connection) throws SQLException
    {
        String insertLink = "INSERT INTO Movie_Directors (movie_id, director_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertLink)) {
            for (Integer directorId : directorIds) {
                insertStmt.setInt(1, movieId);
                insertStmt.setInt(2, directorId);
                insertStmt.executeUpdate();
            }
        }
    }

    public void linkMovieToWriters(int movieId, List<Integer> writerIds, Connection connection) throws SQLException
    {
        String insertLink = "INSERT INTO Movie_Writers (movie_id, writer_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertLink)) {
            for (Integer writerId : writerIds) {
                insertStmt.setInt(1, movieId);
                insertStmt.setInt(2, writerId);
                insertStmt.executeUpdate();
            }
        }
    }

    public void linkMovieToActors(int movieId, List<Integer> actorIds, Connection connection) throws SQLException
    {
        String insertLink = "INSERT INTO Movie_Actors (movie_id, actor_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertLink)) {
            for (Integer actorId : actorIds) {
                insertStmt.setInt(1, movieId);
                insertStmt.setInt(2, actorId);
                insertStmt.executeUpdate();
            }
        }
    }






    public static void main(String[] args)
    {
        MovieCollection test = new MovieCollection();
        /*
         * example Barbie original rating is 6.9 and description:"Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans."
         */

        String titleToUpdate =JOptionPane.showInputDialog("Enter the title of the movie to make an update to the database:");
        String description= JOptionPane.showInputDialog("Enter new description for the movie "+ titleToUpdate);
        double rating=0;
        boolean isDouble=false;
        while (!isDouble)
        {
            String input = JOptionPane.showInputDialog("Enter new rating for the movie  " + titleToUpdate);

            // Validate if the input can be parsed as a double
            try {
                rating = Double.parseDouble(input);
                isDouble = true;
            } catch (NumberFormatException e) {
                // Invalid input, show error message
                JOptionPane.showMessageDialog(null, "Invalid rating entered. Please enter a valid number.");
            }
        }

        test.updateDatabase(titleToUpdate, rating, description);

        test.loadMovieFileAndAddToDatabase(); // uploads the textfile to the database
        int x=1;
        int max= test.maxNumberOfMoviesInDB();// number of movies in the database
        test.fetchMovieDataForJavaCollection(x,max);// "download" the movie information the database to load into the java movie collection list

        test.displayMovies(); // this will display all the movies in the database and the update that was made to a movie

        /*
         * Example of movie titles to try
         * Barbie
         * Zootopia
         * Elemental
         */

        String titleToDelete = JOptionPane.showInputDialog("Enter the title of the movie to delete from the database:");
        if (titleToDelete != null && !titleToDelete.trim().isEmpty())
        {
            int movie_Id=test.findMovieIdByTitleFromDatabase(titleToDelete);
            test.deleteMovieFromDatabase(movie_Id,test.movies);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No title entered.");
        }


        System.out.println("\n\n\n\n\n\n");
        // will show the deletion based on title
        test.displayMovies();


        /*
         * image names related to movies examples ( this is what imagePath must equal)
         * JohnWick3
         * Zootopia
         * Coco
         */
        System.out.println("\n\n\n\n\n\n");
        String imageToDelete = JOptionPane.showInputDialog("Enter the name of the movie image to delete the movie from the database:");
        if (imageToDelete != null && !titleToDelete.trim().isEmpty())
        {
            String imagePath="resources/movieImages/"+imageToDelete+".png";// this like create the standard for image path minus the name of the image
            int movie_id2= test.findMovieIdByImageFromDatabase(imageToDelete);
            test.deleteMovieFromDatabase(movie_id2,test.movies);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No title entered.");
        }
        //will show the deletion based on image path file
        test.displayMovies();


    }



}// end of class


