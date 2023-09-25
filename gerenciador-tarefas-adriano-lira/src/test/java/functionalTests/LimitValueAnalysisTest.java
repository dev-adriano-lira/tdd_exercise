package functionalTests;

import org.example.Priority;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LimitValueAnalysisTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testTaskOrderingByEarlierDate() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-10", Priority.HIGH);
        taskManager.createTask(2, "Task 2", "Description", "2023-09-09", Priority.HIGH);
        assertEquals(2, taskManager.getAllTasks().get(0).getId());
        assertEquals(1, taskManager.getAllTasks().get(1).getId());
    }

    @Test
    public void testTaskOrderingByHigherPriority() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-10", Priority.HIGH);
        taskManager.createTask(2, "Task 2", "Description", "2023-09-10", Priority.MEDIUM);
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }

    @Test
    public void testTaskOrderingByPriorityWhenDatesAreEqual() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-10", Priority.MEDIUM);
        taskManager.createTask(2, "Task 2", "Description", "2023-09-10", Priority.LOW);
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }

    /*@Test
    public void testOrderingByDateOverHighPriority() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-09", Priority.LOW);
        taskManager.createTask(2, "Task 2", "Description", "2023-09-10", Priority.HIGH);
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }*/

    /* Os dois testes estão comentados para não dar erro de compilação, pois o método retorna void. Esses são casos que
    deveriam ser verificados, mas não são.
    @Test
    public void testInvalidDateOverHighPriorityReturnsError() {
        String result_1 = taskManager.createTask(1, "Task 1", "Description", "2023-09-09", Priority.LOW);
        String result_2 = taskManager.createTask(2, "Task 2", "Description", "", Priority.HIGH);
        assertEquals("ERRO (Data inválida)", result_2);
    }

    @Test
    public void testInvalidDateWithDifferentPrioritiesReturnsError() {
        String result_1 = taskManager.createTask(1, "Task 1", "Description", "", Priority.HIGH);
        String result_2 = taskManager.createTask(2, "Task 2", "Description", "2023-09-09", Priority.LOW);
        assertEquals("ERRO (Data inválida)", result_1);
    }
    */
}
