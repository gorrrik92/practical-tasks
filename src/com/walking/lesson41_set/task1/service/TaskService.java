package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskService {
    private Set<Task> tasks;

    public TaskService(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskService() {
        this.tasks = new LinkedHashSet<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println(task + " has been added");
    }

    public void executeAllTask() throws InterruptedException {
        System.out.println("=========Task execution=======");
        for (Task task : tasks) {
            Thread.sleep(task.getDelay());
            System.out.println(task + " has been executed");
        }
        tasks.clear();
    }
}
