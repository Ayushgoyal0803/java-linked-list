package CircularLinkedList.TicketReservation;

public class Node {
    String ticketId, customerName, movieName, seatNumber, bookingTime;
    Node next;

    Node(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
