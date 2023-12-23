package com.walking.lesson41_set.task1.model;

public class Task {
    private final String name;
    private int delay;

    public Task(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", delay=" + delay +
                '}';
    }
}
