package junit5Tests;

import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PartitionOfEquivalenceTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @ParameterizedTest
    @MethodSource("provideTasksForAddition")
    @DisplayName("Teste de Adição de Tarefa")
    void testAddTask(Task expectedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        Task addedTask = taskManager.getTaskById(expectedTask.getId());

        assertEquals(expectedTask, addedTask);
    }

    @ParameterizedTest
    @MethodSource("provideTasksForUpdateAndOrdering")
    @DisplayName("Teste de Atualização e Ordenação de Tarefa")
    void testTaskUpdateAndOrdering(Task expectedTask, Task updatedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());

        assertEquals(updatedTask, retrievedTask);
    }

    @ParameterizedTest
    @MethodSource("provideTasksForPriorityUpdate")
    @DisplayName("Teste de Atualização de Prioridade por ID")
    void testPriorityUpdateForTaskById(Task expectedTask, Task updatedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());
        assertEquals(updatedTask, retrievedTask);
    }

    @ParameterizedTest(name = "Teste de Deleção de Tarefa por ID")
    @MethodSource("provideTasksForDeletion")
    @DisplayName("Teste de Deleção de Tarefa por ID")
    void testDeletionOfTaskById(Task expectedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.deleteTask(expectedTask.getId());
        assertNull(taskManager.getTaskById(expectedTask.getId()));
    }

    @Test
    @DisplayName("Verifica se é retornado null ao pesquisar por um id de task que não existe no sistema")
    void testGetTaskByIdWithNonexistentId() {
        assertNull(taskManager.getTaskById(1));
        assertNull(taskManager.getTaskById(2));
    }

    static Stream<Arguments> provideTasksForAddition() {
        return Stream.of(
                Arguments.of(new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH)),
                Arguments.of(new Task(2, "Task2", "Description2", "2023-10-11", Priority.MEDIUM))
        );
    }

    static Stream<Arguments> provideTasksForUpdateAndOrdering() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH),
                        new Task(1, "NewTask", "NewDescription", "2023-10-13", Priority.MEDIUM)
                ),
                Arguments.of(
                        new Task(2, "Task2", "Description2", "2023-10-13", Priority.HIGH),
                        new Task(2, "NewTas2", "NewDescription2", "2023-10-15", Priority.MEDIUM)
                )
        );
    }

    static Stream<Arguments> provideTasksForPriorityUpdate() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Title1", "Description1", "2023-09-15", Priority.MEDIUM),
                        new Task(1, "Title1", "Description1", "2023-09-15", Priority.HIGH)
                ),
                Arguments.of(
                        new Task(2, "Title2", "Description2", "2023-09-17", Priority.MEDIUM),
                        new Task(2, "Title2", "Description2", "2023-09-17", Priority.HIGH)
                )
        );
    }

    static Stream<Arguments> provideTasksForDeletion() {
        return Stream.of(
                Arguments.of(new Task(1, "", "", "", Priority.HIGH)),
                Arguments.of(new Task(2, "", "", "", Priority.HIGH))
        );
    }
}
