package ru.netology.javacore;

import java.util.Collections;
import java.util.List;

public class Operations {

    public List<String> addTask (List<String> tasks, String task) {
        tasks.add(task);
        Collections.sort(tasks);
        return tasks;
    }

    public List<String> removeTask (List<String> tasks, String task) {
        boolean isRemoved = tasks.remove(task);
        if (isRemoved) {
            System.out.println("Задача '" + task + "' удалена");
        } else {
            System.out.println("Задачи '" + task + "' нет в списке");
        }
        return tasks;
    }
}
