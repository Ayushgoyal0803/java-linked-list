package CircularLinkedList.TaskScheduler;

public class TaskScheduler {
    private Node head;
    private Node tail;
    private Node currentTask;

    public void addAtBeginning(String taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(String taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void removeTask(String taskId) {
        if (head == null) return;
        if (head.taskId.equals(taskId)) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.next;
            tail.next = head;
            return;
        }
        Node curr = head;
        while (curr.next != tail && !curr.next.taskId.equals(taskId)) {
            curr = curr.next;
        }
        if (curr.next.taskId.equals(taskId)) {
            curr.next = curr.next.next;
            if (curr.next == head) tail = curr;
        }
    }

    public void viewCurrentTask() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
            currentTask = currentTask.next;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.println(curr.taskId + ": " + curr.taskName + " (Priority: " + curr.priority + ", Due: " + curr.dueDate + ")");
            curr = curr.next;
        } while (curr != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) return;
        Node curr = head;
        boolean found = false;
        do {
            if (curr.priority == priority) {
                System.out.println("Task Found: " + curr.taskName + " (ID: " + curr.taskId + ")");
                found = true;
            }
            curr = curr.next;
        } while (curr != head);
        if (!found) System.out.println("No task found with priority " + priority);
    }
}
