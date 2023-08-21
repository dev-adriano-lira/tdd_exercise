import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void testCreateTask() {

        Task expectedTask = new Task(1, "Title 1", "Description 1", "2023-08-31", Priority.MEDIUM);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(), expectedTask.getDueDate(), expectedTask.getPriority());
        Task retrievedTask = taskManager.getTaskById(1);

        assertEquals(expectedTask, retrievedTask);
    }
/*
    @Test
    void testUpdateTaskDetails() {
        Task originalTask = new Task("Title 2", "Description 2", "2023-09-15", Priority.LOW);
        taskManager.createTask(originalTask);

        Task updatedTask = new Task(originalTask.getId(), "Updated Title", "Updated Description", "2023-09-20", Priority.HIGH);
        taskManager.updateTask(updatedTask);

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());

        assertEquals(updatedTask, retrievedTask);
    }

    @Test
    void testDeleteTask() {
        Task taskToDelete = new Task("Title 3", "Description 3", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(taskToDelete);

        taskManager.deleteTask(taskToDelete.getId());

        Task retrievedTask = taskManager.getTaskById(taskToDelete.getId());

        assertNull(retrievedTask);
    }

    @Test
    void testListTasksOrderedByDueDateAndPriority() {
        Task task1 = new Task("Task 1", "Description 1", "2023-08-31", Priority.MEDIUM);
        Task task2 = new Task("Task 2", "Description 2", "2023-08-30", Priority.HIGH);
        Task task3 = new Task("Task 3", "Description 3", "2023-08-31", Priority.LOW);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        List<Task> tasks = taskManager.listTasksOrderedByDueDateAndPriority();

        assertEquals(task2, tasks.get(0));
        assertEquals(task1, tasks.get(1));
        assertEquals(task3, tasks.get(2));
    }

    @Test
    void testSetTaskPriority() {
        Task task = new Task("Task with Priority", "Description", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task);

        taskManager.setTaskPriority(task.getId(), Priority.HIGH);

        Task updatedTask = taskManager.getTaskById(task.getId());

        assertEquals(Priority.HIGH, updatedTask.getPriority());
    }

*/
}
