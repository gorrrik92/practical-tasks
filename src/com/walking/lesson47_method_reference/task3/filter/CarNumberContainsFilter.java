package com.walking.lesson47_method_reference.task3.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

public class CarNumberContainsFilter implements CarFilter {
    private String numberPart;

    public CarNumberContainsFilter(String numberPart) {
        this.numberPart = numberPart;
    }

    @Override
    public boolean filter(Car car) {
        return car.getIdentifier().getNumber().toUpperCase().contains(numberPart.toUpperCase());
    }
}
