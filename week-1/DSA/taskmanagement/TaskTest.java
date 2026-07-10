package DSA.taskmanagement;

public class TaskTest {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Add tasks
        taskList.addTask(new Task("T101", "Design Module", "Pending"));
        taskList.addTask(new Task("T102", "Develop Feature", "In Progress"));
        taskList.addTask(new Task("T103", "Test Application", "Pending"));

        // Traverse
        taskList.traverseTasks();

        // Search
        Task task = taskList.searchTask("T102");
        System.out.println("\nSearch Result: " + (task != null ? task : "Not Found"));

        // Delete
        taskList.deleteTask("T103");

        // Final traverse
        taskList.traverseTasks();
    }
}

