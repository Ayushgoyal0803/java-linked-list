package CircularLinkedList.TaskScheduler;

public class Node {
        String taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(String taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
}