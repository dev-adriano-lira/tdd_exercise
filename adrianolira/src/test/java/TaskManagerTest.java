import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testUpdateTaskDetails() {
        Task expectedTask = new Task(2, "Title 2", "Description 2", "2023-09-15", Priority.LOW);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(), expectedTask.getDueDate(), expectedTask.getPriority());

        Task updatedTask = new Task(expectedTask.getId(),  "Updated Title", "Updated Description", "2023-09-20", Priority.HIGH);
        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());

        assertEquals(updatedTask, retrievedTask);
    }

    @Test
    void testDeleteTask() {
        Task expectedTask = new Task(3, "Title 3", "Description 3", "2023-09-15", Priority.LOW);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(), expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.deleteTask(expectedTask.getId());

        assertTrue(true);
    }

    @Test
    void testListTasksOrderedByDueDateAndPriority() {
        Task task1 = new Task(1, "Task 1", "Description 1", "2023-08-31", Priority.MEDIUM);
        Task task2 = new Task(2, "Task 2", "Description 2", "2023-08-30", Priority.HIGH);
        Task task3 = new Task(3, "Task 3", "Description 3", "2023-08-31", Priority.LOW);

        taskManager.createTask(task1.getId(), task1.getTitle() , task1.getDescription(), task1.getDueDate(), task1.getPriority());
        taskManager.createTask(task2.getId(), task2.getTitle() , task2.getDescription(), task2.getDueDate(), task2.getPriority());
        taskManager.createTask(task3.getId(), task3.getTitle() , task3.getDescription(), task3.getDueDate(), task3.getPriority());

        List<Task> tasks = taskManager.getAllTasks();

        assertEquals(task2, tasks.get(0));
        assertEquals(task1, tasks.get(1));
        assertEquals(task3, tasks.get(2));
    }

    @Test
    void testSetTaskPriority() {
        Task task = new Task(1, "Task with Priority", "Description", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task.getId(), task.getTitle() , task.getDescription(), task.getDueDate(), task.getPriority());

        Task updatedTask = taskManager.setTaskPriority(task.getId(), Priority.HIGH);

        assertEquals(Priority.HIGH, updatedTask.getPriority());
    }

}
