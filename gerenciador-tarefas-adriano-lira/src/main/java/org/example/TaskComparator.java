package org.example;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        int priorityComparison = task1.getPriority().compareTo(task2.getPriority());
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return task1.getDueDate().compareTo(task2.getDueDate());
    }
}
