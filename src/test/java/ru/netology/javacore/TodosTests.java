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
    public void initTodos () {
        todos = new Todos();
    }

    @Test
    public void emptyTasksList () {
        Todos todos = new Todos();
        Assertions.assertEquals("", todos.getAllTasks());
    }

    @Test
    public void positiveCheckSorting () {
        Operations operations = new Operations();
        List<String> tasks = new ArrayList<>(List.of(new String[]{"2", "6", "0", "Tasks"}));
        for (String task : tasks) {
            todos.setTasks(operations.addTask(todos.getTasks(), task));
        }
        Collections.sort(tasks);
        Assertions.assertEquals(tasks, todos.getTasks());
    }

    @Test
    public void correctSetEmptyTasks () {
        List<String> tasks = new ArrayList<>();
        tasks.add("Task#1");
        todos.setTasks(tasks);
        Assertions.assertEquals(tasks, todos.getTasks());
        todos.setTasks(new ArrayList<>());
        Assertions.assertEquals("", todos.getAllTasks());
    }
}
