package CircularLinkedList.RoundRobinScheduler;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess("P1", 10, 1);
        scheduler.addProcess("P2", 5, 2);
        scheduler.addProcess("P3", 8, 3);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        scheduler.executeProcesses();
    }
}
