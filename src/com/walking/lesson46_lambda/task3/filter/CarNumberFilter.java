package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class CarNumberFilter implements CarFilter {
    private String number;

    public CarNumberFilter(String number) {
        this.number = number;
    }

    @Override
    public boolean filter(Car car) {
        return car.getIdentifier().getNumber().equalsIgnoreCase(number);
    }
}
