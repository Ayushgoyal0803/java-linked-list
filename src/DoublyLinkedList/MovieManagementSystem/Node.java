package DoublyLinkedList.MovieManagementSystem;

public class Node {
    String movieTitle;
    String directorName;
    int yearOfRelease;
    double rating;

    Node next;
    Node prev;

    Node(String movieTitle, String directorName, int yearOfRelease, double rating){
        this.movieTitle = movieTitle;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        next = null;
        prev = null;
    }
}
