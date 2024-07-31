class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    // Add a task to the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Add tasks
        taskList.addTask(new Task("T001", "Design UI", "Pending"));
        taskList.addTask(new Task("T002", "Implement Backend", "In Progress"));
        taskList.addTask(new Task("T003", "Testing", "Pending"));

        // Traverse tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for Task with ID T002:");
        Task task = taskList.searchTask("T002");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task
        System.out.println("\nDeleting Task with ID T002");
        taskList.deleteTask("T002");

        // Traverse tasks again
        System.out.println("\nAll Tasks after Deletion:");
        taskList.traverseTasks();
    }
}
