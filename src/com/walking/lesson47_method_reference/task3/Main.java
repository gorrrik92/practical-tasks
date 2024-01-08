package com.walking.lesson47_method_reference.task3;


import com.walking.lesson47_method_reference.task3.model.Car;
import com.walking.lesson47_method_reference.task3.service.CarService;
import com.walking.lesson47_method_reference.task3.service.InputService;

import java.util.List;

/**
 * Реализуйте Задачу 3 из урока 46,
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис,
 * если это не было сделано ранее.
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
