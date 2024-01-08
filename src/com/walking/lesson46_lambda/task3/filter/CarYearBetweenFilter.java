package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class CarYearBetweenFilter implements CarFilter {
    private int yearFrom;
    private int yearTo;

    public CarYearBetweenFilter(int yearFrom, int yearTo) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    @Override
    public boolean filter(Car car) {
        int carYear = car.getIdentifier().getYear();
        return (yearFrom <= carYear) && (carYear <= yearTo);
    }
}