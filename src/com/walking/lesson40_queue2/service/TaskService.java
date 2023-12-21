package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TaskService {
    private Deque<Task> tasks;

    public TaskService(Deque<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskService() {
        this.tasks = new ArrayDeque<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println(task + " has been added");
    }

    public void executeAllTask() throws InterruptedException {
        while (tasks.peekFirst() != null) {
            Task nextTask = tasks.pollFirst();
            Thread.sleep(nextTask.getDelay());
            System.out.println(nextTask + " has been executed");
        }
    }
}
