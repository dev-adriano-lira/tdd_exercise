package functionalTests;

import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecisionTablesTests {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testTaskUpdateWithValidDueDate() {
        Task expectedTask = new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        Task updatedTask = new Task(expectedTask.getId(),  "NewTask", "NewDescription",
                "2023-10-13", Priority.MEDIUM);
        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());

        assertEquals(updatedTask, retrievedTask);
    }

    /* O teste está comentado para não dar erro de compilação, pois o método retorna void. Esse é um caso que
    deveria ser verificado, mas não é.
    @Test
    public void testUpdateNonexistentTaskWithValidDateReturnsNotFoundError() {
        Task expectedTask = new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        Task updatedTask = new Task(2,  "NewTask", "NewDescription",
                "2023-10-13", Priority.MEDIUM);
        String result = taskManager.updateTask(2, updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        assertEquals("ERRO (Task não encontrada)", result);
    }
    */

    @Test
    public void testCreateTaskWithValidDataAndDateSuccess() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-10", Priority.HIGH);
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
    }

    /* O teste está comentado para não dar erro de compilação, pois o método retorna void. Esse é um caso que
    deveria ser verificado, mas não é.
    @Test
    public void testUpdateNonexistentTaskWithInvalidDateReturnsNotFoundError() {
        Task expectedTask = new Task(1, "Task1", "Description1", "", Priority.HIGH);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        Task updatedTask = new Task(2,  "NewTask", "NewDescription",
                "", Priority.MEDIUM);
        String result = taskManager.updateTask(2, updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        assertEquals("ERRO (Task não encontrada)", result);
    }
    */
}
