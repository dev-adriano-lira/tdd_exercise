package org.example;

import java.util.Objects;

public class Task {

    private int id;
    private String title;
    private String description;
    private String dueDate;
    private Priority priority;

    public Task(int id, String title, String description, String dueDate, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void updateDetails(String title, String description, String dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description +
                "\nDue Date: " + dueDate + "\nPriority: " + priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(dueDate, task.dueDate) &&
                priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, priority);
    }
}
