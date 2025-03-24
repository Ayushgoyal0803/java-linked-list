package DoublyLinkedList.LibraryManagementSystem;

public class Node {
    String bookTitle;
    String authorName;
    String genre;
    String bookId;
    boolean isAvailable;
    Node next;
    Node prev;

    Node( String bookTitle, String authorName, String genre, String bookId, boolean isAvailable){
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;

    }
}
