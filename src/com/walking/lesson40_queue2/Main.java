package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

/**
 * Реализуйте класс Задание. Он должен содержать поле Название,
 * состав остальных полей - на ваше усмотрение.
 * <p>
 * Реализуйте сервис, хранящий задания.
 * Он должен иметь методы для добавления заданий и их "выполнения".
 * Задания должны обрабатываться в порядке очереди.
 * Критерием выполнения задания будем считать выведение в консоль фразы
 * "Задание %название задания% выполнено!".
 * <p>
 * Также добавьте вывод сообщения в консоль о том,
 * что задание (с указанием названия) добавлено.
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
        System.out.println("=========Task execution=======");
        service.executeAllTask();
    }
}
