package com.walking.lesson46_lambda.task3;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.service.CarService;
import com.walking.lesson46_lambda.task3.service.InputService;

import java.util.List;

/**
 * Реализуйте Задачу из урока 21:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object">...</a>
 * с использованием списка (или другой коллекции на ваш выбор).
 * Дайте возможность искать машины по гибкому фильтру –
 * возвращайте коллекцию машин, подходящих под конкретный фильтр (можете расширить на свой вкус):
 * · Номер совпадает с введенным пользователем;
 * · Номер содержит подстроку, указанную пользователем;
 * · Цвет совпадает с указанным пользователем;
 * · Год выпуска машины находится в диапазоне, указанном пользователем.
 * <p>
 * При этом CarService должен содержать лишь один публичный метод поиска.
 * Можете использовать Predicate или собственный функциональный интерфейс.
 * <p>
 * Также реализуйте интерактивное меню в рамках консоли,
 * позволяющее производить несколько поисков в рамках одного запуска программы.
 * Предусмотрите возможность завершения программы с помощью пользовательского ввода.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        InputService inputService = new InputService(System.in, carService);

        try {
            inputService.processMenu();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            inputService.destroy();
        }
    }

    private static List<Car> initCars() {
        return List.of(
                new Car("RR-111-RR", 2005, "yellow", true),
                new Car("RR-111-RR", 2015, "yellow", true),
                new Car("RR-222-RR", 2016, "silver", true),
                new Car("RR-333-RR", 2017, "blue", true),
                new Car("RR-444-RR", 2018, "yellow", true),
                new Car("RR-555-RR", 2018, "black", true),
                new Car("RR-666-RR", 2018, "yellow", true),
                new Car("RR-777-RR", 2020, "yellow", true),
                new Car("RR-888-RR", 2018, "green", true),
                new Car("RR-999-RR", 2008, "white", true),
                new Car("RR-000-RR", 2018, "yellow", true));
    }
}