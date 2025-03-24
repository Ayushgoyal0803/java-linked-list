package CircularLinkedList.RoundRobinScheduler;

public class RoundRobinScheduler {
    private Node head;
    private Node tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(String processId, int burstTime, int priority) {
        Node newNode = new Node(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void executeProcesses() {
        if (head == null) return;
        Node curr = head;
        int totalTime = 0, waitingTime = 0, turnAroundTime = 0, count = 0;

        while (head != null) {
            if (curr.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, curr.burstTime);
                System.out.println("Executing Process " + curr.processId + " for " + executionTime + " units");
                curr.burstTime -= executionTime;
                totalTime += executionTime;

                if (curr.burstTime == 0) {
                    System.out.println("Process " + curr.processId + " completed.");
                    waitingTime += (totalTime - executionTime);
                    turnAroundTime += totalTime;
                    removeProcess(curr.processId);
                }
            }
            curr = curr.next;
        }
        count++;
        System.out.println("Average Waiting Time: " + (double) waitingTime / count);
        System.out.println("Average Turnaround Time: " + (double) turnAroundTime / count);
    }

    public void removeProcess(String processId) {
        if (head == null) return;
        if (head.processId.equals(processId)) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Node curr = head;
        while (curr.next != tail && !curr.next.processId.equals(processId)) {
            curr = curr.next;
        }
        if (curr.next.processId.equals(processId)) {
            curr.next = curr.next.next;
            if (curr.next == head) tail = curr;
        }
    }

    public void displayProcesses() {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.println("Process " + curr.processId + " (Burst Time: " + curr.burstTime + ", Priority: " + curr.priority + ")");
            curr = curr.next;
        } while (curr != head);
    }
}
