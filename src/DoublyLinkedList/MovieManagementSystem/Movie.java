package DoublyLinkedList.MovieManagementSystem;

public class Movie {
    Node head;
    Node tail;

    // add node at beginning
    public void addAtBeginning(String movieTitle, String directorName , int yearOfRelease, double rating){
        Node newNode = new Node(movieTitle,directorName,yearOfRelease,rating);
        if(head != null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
    }

    // add node at last
    public void addAtLast(String movieTitle, String directorName , int yearOfRelease, double rating){
        Node newNode = new Node(movieTitle,directorName,yearOfRelease,rating);
        if(tail == null){
            tail = newNode;
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // add node at specific position
    public void addAtSpecificPosition(String movieTitle, String directorName , int yearOfRelease, double rating, int position){
        Node newNode = new Node(movieTitle, directorName, yearOfRelease, rating );

        if (position==0){
            addAtBeginning(movieTitle, directorName, yearOfRelease, rating);
            return;
        }

        Node curr = head;
        int currPos = 0;

        while (curr != null && currPos < position-1 ){
            curr = curr.next;
            currPos++;
        }

        if(curr == null){
            addAtLast(movieTitle, directorName, yearOfRelease, rating);
            return;
        }

        newNode.next = curr.next;
        newNode.prev = curr;
        if(curr.next != null){
            curr.next.prev = newNode;
        }
        curr.next = newNode;

        if(newNode.next == null){
            tail = newNode;
        }
    }

    // Display all records
    public void displayAll(){
        if(head ==null){
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;

        while (curr != null){
            System.out.println("Movie Title: " + curr.movieTitle);
            System.out.println("Director: " + curr.directorName);
            System.out.println("Year of Release: " + curr.yearOfRelease);
            System.out.println("Rating: " + curr.rating);
            System.out.println("------------");
            curr = curr.next;

        }
    }

    // display all records in reverse order
    public void displayReverse(){
        if(tail==null){
            System.out.println("List is empty.");
            return;
        }
        Node curr = tail;

        while (curr != null){
            System.out.println("Movie Title: " + curr.movieTitle);
            System.out.println("Director: " + curr.directorName);
            System.out.println("Year of Release: " + curr.yearOfRelease);
            System.out.println("Rating: " + curr.rating);
            System.out.println("------------");
            curr = curr.prev;

        }
    }


    public void searchMovie(String directorName) {
        if(head.directorName.equals(directorName)){
            System.out.println("Found the movie: " + head.movieTitle);
            return;
        }
        Node curr = head;
        while (curr != null && !curr.directorName.equals(directorName) ){
            curr = curr.next;
        }
        if(curr != null){
            System.out.println("Found the movie: " + head.movieTitle);
        }else {
            System.out.println("No movie found");
        }
    }

    public void searchMovie(double rating){
        if(head.rating == rating){
            System.out.println("Found the movie: " + head.movieTitle);
            return;
        }
        Node curr = head;
        while (curr != null && curr.rating != rating){
            curr = curr.next;
        }
        if(curr !=null){
            System.out.println("Found the movie: " + head.movieTitle);
        }else{
            System.out.println("No movie found");
        }
    }

    public void updateRating(String movieTitle, double rating){
        Node curr = head;
        while (curr != null && !curr.movieTitle.equals(movieTitle)){
            curr = curr.next;
        }

        if(curr != null){
            curr.rating = rating;
        }
        else {
            System.out.println("No movie found");
        }
    }

    public void removeMovie(String movieTitle) {
        // Case 1: Check if the list is empty
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 2: If the movie to be removed is the head
        if (head.movieTitle.equals(movieTitle)) {
            head = head.next;
            if (head != null) {
                head.prev = null;  // Remove the backward reference from the new head
            } else {
                tail = null;  // If the list becomes empty, set tail to null
            }
            System.out.println("Movie removed: " + movieTitle);
            return;
        }

        // Case 3: If the movie to be removed is the tail
        if (tail.movieTitle.equals(movieTitle)) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;  // Remove the forward reference from the new tail
            } else {
                head = null;  // If the list becomes empty, set head to null
            }
            System.out.println("Movie removed: " + movieTitle);
            return;
        }

        // Case 4: If the movie to be removed is somewhere in the middle
        Node curr = head;
        while (curr != null && !curr.movieTitle.equals(movieTitle)) {
            curr = curr.next;
        }

        if (curr != null) {
            curr.prev.next = curr.next;  // Bypass the current node from the previous node
            if (curr.next != null) {
                curr.next.prev = curr.prev;  // Bypass the current node from the next node
            }
            System.out.println("Movie removed: " + movieTitle);
        } else {
            System.out.println("No movie found with the title: " + movieTitle);
        }
    }



}

