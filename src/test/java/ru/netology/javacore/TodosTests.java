package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TodosTests {

    Todos todos;

    @BeforeAll
    public void initTextGraphicsConverterNew () {
        todos = new Todos();
    }

    @Test
    public void emptyTasksList () {
        Assertions.assertEquals("", todos.getAllTasks());
    }

    @Test
    public void positiveCheckSorting() {
        List<String> tasks = new ArrayList<>(List.of(new String[]{"2", "6", "0", "Tasks"}));
        for (String task : tasks) {
            todos.addTask(task);
        }
        Collections.sort(tasks);
        Assertions.assertEquals(tasks, todos.getTasks());
    }
    @Test
    public void checkUpperCase() {
        String addOperation = "add";
        Todos todo = new Todos(addOperation, "Task");
        Assertions.assertEquals(addOperation.toUpperCase(), todo.type);
    }
}
