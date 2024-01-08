package com.walking.lesson47_method_reference.task1;

import com.walking.lesson47_method_reference.task1.model.Car;

import java.util.List;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = initCars();
        cars.forEach(System.out::println);
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
    }}
