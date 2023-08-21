package org.example;

public class Task {
    private String title;
    private String description;
    private String dueDate;
    private Priority priority;

    public Task(String title, String description, String dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
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

    public void updateDetails(String title, String description, String dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description +
                "\nDue Date: " + dueDate + "\nPriority: " + priority + "\n";
    }
}
