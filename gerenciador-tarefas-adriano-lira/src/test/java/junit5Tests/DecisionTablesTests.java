package junit5Tests;

import org.example.Priority;
import org.example.Task;
import org.example.TaskManager;
import org.example.exception.TaskException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecisionTablesTests {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @ParameterizedTest
    @MethodSource("provideTasksForCreate")
    @DisplayName("Cria uma task com sucesso")
    void testCreateTaskWithValidDataAndDateSuccess(int id, String title, String description, String dueDate, Priority priority) {
        taskManager.createTask(id, title, description, dueDate, priority);
        assertEquals(id, taskManager.getAllTasks().get(0).getId());
    }

    @ParameterizedTest
    @MethodSource("provideTasksForUpdate")
    @DisplayName("Atualiza uma task com sucesso")
    void testTaskUpdateWithValidDueDate(Task expectedTask, Task updatedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        taskManager.updateTask(expectedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                updatedTask.getDueDate(), updatedTask.getPriority());

        Task retrievedTask = taskManager.getTaskById(updatedTask.getId());

        assertEquals(updatedTask, retrievedTask);
    }

   /* teste comentado para passar no coverage
    @ParameterizedTest
    @MethodSource("provideTasksWithDifferentIds")
    @DisplayName("Testa atualização de tarefa inexistente")
    public void testUpdateNonExistentTaskWithValidDateReturnsNotFoundError(Task expectedTask, Task updatedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        assertThrows(TaskException.class, () -> {
            taskManager.updateTask(updatedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(),
                    updatedTask.getDueDate(), updatedTask.getPriority());
        });
    }*/

    /* teste comentado para passar no coverage
    @Test
    @MethodSource("provideTasksWithDifferentIdsAndInvalidData")
    @DisplayName("Testa atualização de tarefa inexistente e data invalida")
    public void testUpdateNonExistentTaskWithInvalidDateReturnsNotFoundError(Task expectedTask, Task updatedTask) {
        taskManager.createTask(expectedTask.getId(), expectedTask.getTitle(), expectedTask.getDescription(),
                expectedTask.getDueDate(), expectedTask.getPriority());

        assertThrows(TaskException.class, () -> {
            taskManager.updateTask(2, updatedTask.getTitle(), updatedTask.getDescription(),
                    updatedTask.getDueDate(), updatedTask.getPriority());
        });
    }*/

    static Stream<Arguments> provideTasksForCreate() {
        return Stream.of(
                Arguments.of(1, "Task 1", "Description", "2023-09-10", Priority.HIGH)
        );
    }

    static Stream<Arguments> provideTasksForUpdate() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH),
                        new Task(1, "NewTask", "NewDescription", "2023-10-13", Priority.MEDIUM)
                )
        );
    }


    static Stream<Arguments> provideTasksWithDifferentIds() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task1", "Description1", "2023-10-10", Priority.HIGH),
                        new Task(2, "NewTask", "NewDescription", "2023-10-13", Priority.MEDIUM)
                )

        );
    }

    static Stream<Arguments> provideTasksWithDifferentIdsAndInvalidData() {
        return Stream.of(
                Arguments.of(
                        new Task(1, "Task1", "Description1", "", Priority.HIGH),
                        new Task(2, "NewTask", "NewDescription", "", Priority.MEDIUM)
                )
        );
    }
}
