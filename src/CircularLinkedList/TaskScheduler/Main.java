package CircularLinkedList.TaskScheduler;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning("101", "Code Review", 1, "2025-03-20");
        scheduler.addAtEnd("102", "Write Report", 2, "2025-03-21");
        scheduler.addAtEnd("103", "Team Meeting", 3, "2025-03-21");

        System.out.println("All tasks:");
        scheduler.displayTasks();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        scheduler.searchTaskByPriority(2);
        scheduler.removeTask("102");
        System.out.println("After removal:");
        scheduler.displayTasks();
    }
}

