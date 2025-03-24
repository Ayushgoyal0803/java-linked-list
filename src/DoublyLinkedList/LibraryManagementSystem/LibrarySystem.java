package DoublyLinkedList.LibraryManagementSystem;

public class LibrarySystem {
    private Node head;
    private Node tail;
    private int bookCount;

    public void addAtBeginning(String bookTitle, String authorName, String genre, String bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, authorName, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        bookCount++;
    }

    public void addAtEnd(String bookTitle, String authorName, String genre, String bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, authorName, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        bookCount++;
    }

    public void addAtSpecificPosition(String bookTitle, String authorName, String genre, String bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addAtBeginning(bookTitle, authorName, genre, bookId, isAvailable);
            return;
        }
        if (position >= bookCount) {
            addAtEnd(bookTitle, authorName, genre, bookId, isAvailable);
            return;
        }
        Node newNode = new Node(bookTitle, authorName, genre, bookId, isAvailable);
        Node curr = head;
        for (int i = 0; i < position - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
        bookCount++;
    }

    public void removeBook(String bookId) {
        if (head == null) return;
        if (head.bookId.equals(bookId)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            bookCount--;
            return;
        }
        Node curr = head;
        while (curr != null && !curr.bookId.equals(bookId)) {
            curr = curr.next;
        }
        if (curr != null) {
            if (curr.next != null) curr.next.prev = curr.prev;
            if (curr.prev != null) curr.prev.next = curr.next;
            if (curr == tail) tail = curr.prev;
            bookCount--;
        }
    }

    public void searchBookByTitle(String title) {
        Node curr = head;
        while (curr != null) {
            if (curr.bookTitle.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + curr.bookTitle + " by " + curr.authorName);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book not found.");
    }

    public void searchBookByAuthor(String author) {
        Node curr = head;
        while (curr != null) {
            if (curr.authorName.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + curr.bookTitle + " by " + curr.authorName);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(String bookId, boolean isAvailable) {
        Node curr = head;
        while (curr != null) {
            if (curr.bookId.equals(bookId)) {
                curr.isAvailable = isAvailable;
                return;
            }
            curr = curr.next;
        }
    }

    public void displayForward() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.bookTitle + " by " + curr.authorName + " (" + curr.genre + ") - Available: " + curr.isAvailable);
            curr = curr.next;
        }
    }

    public void displayReverse() {
        Node curr = tail;
        while (curr != null) {
            System.out.println(curr.bookTitle + " by " + curr.authorName + " (" + curr.genre + ") - Available: " + curr.isAvailable);
            curr = curr.prev;
        }
    }

    public int countBooks() {
        return bookCount;
    }
}
