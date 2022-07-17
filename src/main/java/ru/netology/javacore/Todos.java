package ru.netology.javacore;

import java.util.*;

public class Todos {

    StringBuilder builder = new StringBuilder();

    List<String> tasks = new ArrayList<>();

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

    public void addTask (String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask (String task) {
        boolean isRemoved = tasks.remove(task);
        if (isRemoved) {
            System.out.println("Задача '" + task + "' удалена");
        } else {
            System.out.println("Задачи '" + task + "' нет в списке");
        }
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
}
