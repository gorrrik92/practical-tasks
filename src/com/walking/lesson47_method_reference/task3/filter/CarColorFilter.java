package com.walking.lesson47_method_reference.task3.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

public class CarColorFilter  implements CarFilter {
    private String color;

    public CarColorFilter(String color) {
        this.color = color;
    }

    @Override
    public boolean filter(Car car) {
        return car.getColor().equalsIgnoreCase(color);
    }
}