package DoublyLinkedList.LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "001", true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", "002", true);
        library.addAtSpecificPosition("1984", "George Orwell", "Dystopian", "003", true, 1);

        System.out.println("Library books in forward order:");
        library.displayForward();

        System.out.println("Library books in reverse order:");
        library.displayReverse();

        System.out.println("Total books in library: " + library.countBooks());

        library.searchBookByTitle("1984");
        library.searchBookByAuthor("Harper Lee");

        library.updateAvailability("002", false);
        System.out.println("After updating availability:");
        library.displayForward();

        library.removeBook("003");
        System.out.println("After removing a book:");
        library.displayForward();
    }
}
