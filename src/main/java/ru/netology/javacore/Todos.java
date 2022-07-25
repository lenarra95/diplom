package ru.netology.javacore;

import java.util.*;

public class Todos {

    private StringBuilder builder = new StringBuilder();

    private List<String> tasks = new ArrayList<>();

    String type;
    String task;

    public Todos () {
    }

    public Todos (String type, String task) {
        this.type = type.toUpperCase();
        this.task = task;
    }

    public String getType () {
        return type;
    }

    public String getTask () {
        return task;
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
