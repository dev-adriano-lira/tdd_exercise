package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.createTask(1, "Buy groceries", "Milk, eggs, bread", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(2, "Finish project", "Complete documentation", "2023-09-10", Priority.HIGH);
        taskManager.createTask(3, "Go for a run", "Morning jog", "2023-08-22", Priority.LOW);

        System.out.println("All tasks:");
        int tasksCount = 1;
        List<Task> allTasks = taskManager.getAllTasks();
        for (Task task : allTasks) {
            System.out.println("Task " + tasksCount + ":\n" + task);
            tasksCount++;
        }
        tasksCount = 1;

        taskManager.updateTask(1, "Finish project", "Complete coding", "2023-09-15", Priority.HIGH);
        taskManager.deleteTask(2);

        System.out.println("\nUpdated tasks:");
        allTasks = taskManager.getAllTasks();
        for (Task task : allTasks) {
            System.out.println("Task " + tasksCount + ":\n" + task);
            tasksCount++;
        }

    }
}