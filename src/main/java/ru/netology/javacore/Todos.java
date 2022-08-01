package ru.netology.javacore;

import java.util.*;

public class Todos {

    private StringBuilder builder = new StringBuilder();

    private List<String> tasks = new ArrayList<>();

    public Todos () {
    }

    public String getAllTasks () {
        for (String task : tasks) {
            builder.append(task + " ");
        }
        String tasks = builder.toString();
        builder.setLength(0);
        return tasks;
    }

    public List<String> getTasks () {
        return tasks;
    }

    public void setTasks (List<String> tasks) {
        this.tasks = tasks;
    }
}
