package CircularLinkedList.TicketReservation;

public class Main {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();

        system.addTicket("T001", "Alice", "Inception", "A5", "18:00");
        system.addTicket("T002", "Bob", "Interstellar", "B3", "20:00");
        system.addTicket("T003", "Charlie", "Inception", "A6", "18:00");

        system.displayTickets();

        system.searchTicket("Inception");

        system.removeTicket("T002");
        system.displayTickets();

        System.out.println("Total Tickets: " + system.countTotalTickets());
    }
}
