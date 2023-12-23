package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.TaskService;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskService service = new TaskService();
        service.addTask(new Task("Заправить постель", 1000));
        service.addTask(new Task("Почистить зубы", 2000));
        service.addTask(new Task("Побриться", 5000));
        service.addTask(new Task("Подтянуться 5 раз", 3000));
        service.addTask(new Task("Позавтракать", 2000));
        service.addTask(new Task("Одеться", 6000));
        service.addTask(new Task("Дойти до паркинга", 4000));
        service.executeAllTask();
        service.addTask(new Task("Доехать до работы", 10000));
        service.addTask(new Task("Подняться в офис", 2000));
        service.executeAllTask();
    }
}
