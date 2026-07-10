package DSA.taskmanagement;

public class TaskLinkedList {
    private TaskNode head;

    // Add task at end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    // Search task by ID
    public Task searchTask(String taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse tasks
    public void traverseTasks() {
        System.out.println("Task List:");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            System.out.println("Deleted: " + head.task);
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                System.out.println("Deleted: " + current.next.task);
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found!");
    }
}
