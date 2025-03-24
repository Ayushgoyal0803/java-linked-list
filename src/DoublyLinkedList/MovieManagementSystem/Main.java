package DoublyLinkedList.MovieManagementSystem;

public class Main {
    public static void main(String[] args) {
        Movie newMovie = new Movie();
        newMovie.addAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        newMovie.addAtLast("Inception", "Christopher Nolan", 2010, 8.8);
        newMovie.addAtSpecificPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 0 );

        newMovie.displayAll();

        newMovie.searchMovie(9);
        newMovie.searchMovie("Christopher Nolan");
        newMovie.removeMovie("Inception");
        newMovie.updateRating("The Dark Knight",8);

        newMovie.displayReverse();
    }
}
