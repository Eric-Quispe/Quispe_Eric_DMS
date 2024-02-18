import java.util.List;

/**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-26663
 * Date: 1/1/24
 * Movie class creates defines the attributes that a movie object needs in order to create 1 movie.
 * so all movies will have: ID,title,genre,directors,writers,actors,rating,imagePath,description.
 * these movies will be stored in the movieCollection using the list movies.
 */
public class Movie
{
    private int movieId;
    private String title; // 0
    private List<String> genre; //1
    private List<String> director; //2
    private List<String> wrtiers; //3
    private List<String> actors; // 4
    private double rating; // 5
    private String imagePath; // 6
    private String description; // 7

    /*
    Constructor method
     */

    public Movie(int movieId,String title, List<String> genre, List<String> director, List<String> wrtiers, List<String> actors, double rating, String imagePath, String description) {
        this.movieId=movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.wrtiers = wrtiers;
        this.actors = actors;
        this.rating = rating;
        this.imagePath = imagePath;
        this.description = description;
    }
    public int getMovieId ()
    {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId=movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getWriters() {
        return wrtiers;
    }

    public void setWriters(List<String> wrtiers) {
        this.wrtiers = wrtiers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // to String was just to test the new movie text file copies the information
    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", director=" + director +
                ", wrtiers=" + wrtiers +
                ", actors=" + actors +
                ", rating=" + rating +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}// end of movie class
