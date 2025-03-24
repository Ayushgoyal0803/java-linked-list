package CircularLinkedList.TicketReservation;

public class TicketReservation {
    private Node last;
    private int totalTickets;

    public TicketReservation() {
        last = null;
        totalTickets = 0;
    }

    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newNode;
            last.next = last; // Circular reference
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        totalTickets++;
    }

    public void removeTicket(String ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Node current = last.next, prev = last;
        do {
            if (current.ticketId.equals(ticketId)) {
                if (current == last && current.next == last) { // Only one node
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                totalTickets--;
                System.out.println("Ticket " + ticketId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found - ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) System.out.println("No matching ticket found.");
    }

    public int countTotalTickets() {
        return totalTickets;
    }
}
