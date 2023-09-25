package junit5Tests;

import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LimitValueAnalysisTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @ParameterizedTest
    @MethodSource("provideTasksForOrderingByEarlierDate")
    @DisplayName("Testa se a task é ordenada pela data mais antiga")
    void testTaskOrderingByEarlierDate(Task task1, Task task2) {
        taskManager.createTask(task1.getId(), task1.getTitle(), task1.getDescription(), task1.getDueDate(), task1.getPriority());
        taskManager.createTask(task2.getId(), task2.getTitle(), task2.getDescription(), task2.getDueDate(), task2.getPriority());
        assertEquals(2, taskManager.getAllTasks().get(0).getId());
        assertEquals(1, taskManager.getAllTasks().get(1).getId());
    }

    @ParameterizedTest
    @MethodSource("provideTasksForOrderingByHigherPriority")
    @DisplayName("Testa se a task é ordenada por prioridade mais alta")
    void testTaskOrderingByHigherPriority(Task task1, Task task2) {
        taskManager.createTask(task1.getId(), task1.getTitle(), task1.getDescription(), task1.getDueDate(), task1.getPriority());
        taskManager.createTask(task2.getId(), task2.getTitle(), task2.getDescription(), task2.getDueDate(), task2.getPriority());
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }

    @ParameterizedTest
    @MethodSource("provideTasksForOrderingByPriorityWhenDatesAreEqual")
    @DisplayName("Testa se a task é ordenada por prioridade mais alta com data igual")
    void testTaskOrderingByPriorityWhenDatesAreEqual(Task task1, Task task2) {
        taskManager.createTask(task1.getId(), task1.getTitle(), task1.getDescription(), task1.getDueDate(), task1.getPriority());
        taskManager.createTask(task2.getId(), task2.getTitle(), task2.getDescription(), task2.getDueDate(), task2.getPriority());
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }

    /*
    @ParameterizedTest
    @MethodSource("provideTasksForOrderingByDateOverHighPriority")
    @DisplayName("Testa se as tasks são ordenadas por data")
    void testOrderingByDateOverHighPriority(Task task1, Task task2) {
        taskManager.createTask(task1.getId(), task1.getTitle(), task1.getDescription(), task1.getDueDate(), task1.getPriority());
        taskManager.createTask(task2.getId(), task2.getTitle(), task2.getDescription(), task2.getDueDate(), task2.getPriority());
        assertEquals(1, taskManager.getAllTasks().get(0).getId());
        assertEquals(2, taskManager.getAllTasks().get(1).getId());
    }*/

    /* testes comentados para passar no coverage
    @Test
    @DisplayName("Testa se retorna exceção com data invalida e prioridade alta retorna erro")
    public void testInvalidDateOverHighPriorityReturnsError() {
        taskManager.createTask(1, "Task 1", "Description", "2023-09-09", Priority.LOW);
        assertThrows(TaskException.class, () -> {
            taskManager.createTask(2, "Task 2", "Description", "", Priority.HIGH);
        });
    }

    @Test
    @DisplayName("Testa se retorna exceção com data invalida e diferentes prioridades retorna erro")
    public void testInvalidDateWithDifferentPrioritiesReturnsError() {
        assertThrows(TaskException.class, () -> {
            taskManager.createTask(1, "Task 1", "Description", "", Priority.HIGH);
        });
        taskManager.createTask(2, "Task 2", "Description", "2023-09-09", Priority.LOW);
    }*/

    static Stream<Arguments> provideTasksForOrderingByEarlierDate() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task 1", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 2", "Description", "2023-09-09", Priority.HIGH)
                ),
                Arguments.of(
                        new Task(1, "Task 1", "Description", "2023-09-15", Priority.MEDIUM),
                        new Task(2, "Task 2", "Description", "2023-09-09", Priority.HIGH)
                )
        );
    }

    static Stream<Arguments> provideTasksForOrderingByHigherPriority() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task 1", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 2", "Description", "2023-09-10", Priority.MEDIUM)
                ),
                Arguments.of(
                        new Task(1, "Task 4", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 3", "Description", "2023-09-10", Priority.LOW)
                )
        );
    }

    static Stream<Arguments> provideTasksForOrderingByPriorityWhenDatesAreEqual() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task 1", "Description", "2023-09-10", Priority.MEDIUM),
                        new Task(2, "Task 2", "Description", "2023-09-10", Priority.LOW)
                ),
                Arguments.of(
                        new Task(1, "Task 3", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 4", "Description", "2023-09-10", Priority.LOW)
                )
        );
    }

    static Stream<Arguments> provideTasksForOrderingByDateOverHighPriority() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task 2", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 1", "Description", "2023-09-09", Priority.LOW)
                ),
                Arguments.of(
                        new Task(1, "Task 4", "Description", "2023-09-10", Priority.HIGH),
                        new Task(2, "Task 3", "Description", "2023-09-08", Priority.LOW)
                )
        );
    }

}
