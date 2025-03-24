package CircularLinkedList.RoundRobinScheduler;

public class Node {
    String processId;
    int burstTime;
    int priority;
    Node next;

    Node(String processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
