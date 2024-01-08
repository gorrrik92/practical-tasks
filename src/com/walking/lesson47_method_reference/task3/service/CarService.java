package com.walking.lesson47_method_reference.task3.service;

import com.walking.lesson47_method_reference.task3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    //    Упростим реализацию метода в сравнении с вариантом в уроке 19 для большей наглядности
    public List<Car> findCars(Predicate<Car> filter) {
        List<Car> result = new ArrayList<>();
        cars.forEach(car -> {
            if (filter.test(car))
                result.add(car);
        });
//        По желанию можно выбросить исключение
        return result;
    }
}