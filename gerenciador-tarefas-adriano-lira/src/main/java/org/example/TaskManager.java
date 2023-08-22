package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void createTask(int id, String title, String description, String dueDate, Priority priority) {
        Task newTask = new Task(id, title, description, dueDate, priority);
        tasks.add(newTask);
        tasks.sort(new TaskComparator());
    }

    public void updateTask(int id, String title, String description, String dueDate, Priority priority) {
        Task updateTask = getTaskById(id);
        if (updateTask != null) {
            updateTask.updateDetails(title, description, dueDate, priority);
            tasks.sort(new TaskComparator());
        }

    }

    public void deleteTask(int id) {
        Task deleteTask = getTaskById(id);
        if (deleteTask.getId() == id) {
            tasks.remove(deleteTask);
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public Task setTaskPriority(int id, Priority priority) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setPriority(priority);
        }
        return task;
    }
}
