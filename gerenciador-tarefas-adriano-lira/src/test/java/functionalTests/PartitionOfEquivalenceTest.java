package functionalTests;

import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionOfEquivalenceTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        taskManager.createTask(1, "Task1", "Description1", "2023-10-10", Priority.HIGH);

        Task addedTask = taskManager.getTaskById(1);

        assertEquals(1, addedTask.getId());
        assertEquals("Task1", addedTask.getTitle());
        assertEquals("Description1", addedTask.getDescription());
        assertEquals("2023-10-10", addedTask.getDueDate());
        assertEquals(Priority.HIGH, addedTask.getPriority());
    }

    /* Os dois testes estão comentados para não dar erro de compilação, pois o método retorna void. Esses são casos que
    deveriam ser verificados, mas não são.
    @Test
    public void testCreateTaskWithNegativeIdAndReturnsError() {
        String result = taskManager.createTask(-2, "Task2", "Description2", "2023-10-11", Priority.MEDIUM);
        assertEquals("ERRO (ID não pode ser negativo)", result);
    }

    @Test
    public void testInvalidInputsReturnsError() {
        String result = taskManager.createTask(1, "", "", "", Priority.HIGH);
        assertEquals("ERRO (Data inválida)", result_1);
    }
    */

    @Test
    public void testTaskUpdateAndOrdering() {
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
    public void testUpdateNonexistentTaskReturnsNotFoundError() {
        taskManager.createTask(6, "Task5", "Description5", "2023-09-14", Priority.HIGH);
        Task updatedTask = new Task(5,  "Task 5", "Description5", "2023-09-15", Priority.HIGH);
        String result = taskManager.updateTask(5, updatedTask.getTitle(),
            updatedTask.getDescription(), updatedTask.getDueDate(), updatedTask.getPriority());

        assertEquals("ERRO (Task não encontrada)", result);
    }*/

    @Test
    public void testPriorityUpdateForTaskById() {
        Task expectedTask = new Task(1, "Title1", "Description1", "2023-09-15",
                Priority.MEDIUM);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        Task updatedTask = new Task(expectedTask.getId(),  "Title1", "Description1",
                "2023-09-15", Priority.HIGH);
        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());
        assertEquals(updatedTask, retrievedTask);
    }

    @Test
    public void testDeletionOfTaskById() {
        Task expectedTask = new Task(1, "", "", "", Priority.HIGH);
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle() , expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.deleteTask(1);
    }

    /* O teste está comentado para não dar erro de compilação, pois o método retorna void. Esse é um caso que
    deveria ser verificado, mas não é.
    @Test
    public void testPriorityUpdateForNonexistentTaskReturnsNotFoundError() {
        taskManager.createTask(2, "Task 3", "Description3", "2023-09-14", Priority.HIGH);
        assertEquals("ERRO (Task não encontrada)", result);
        Task updatedTask = new Task(3,  "NewTask3", "NewDescription3", "", Priority.HIGH);
        String result = taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(),
            updatedTask.getDescription(), updatedTask.getDueDate(), updatedTask.getPriority());
    }
    */
}
