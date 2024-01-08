package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.filter.*;
import com.walking.lesson46_lambda.task3.model.Car;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class InputService {
    private final static String MAIN_MENU_MESSAGE = "Available menu:\n" +
            "1 - find cars by the input Number\n" +
            "2 - find cars by the input Color\n" +
            "3 - find cars which Number contains input string\n" +
            "4 - find cars which Year is in input range\n" +
            "0 - exit\n";
    private final static String INCORRECT_NUMBER_MESSAGE = "Incorrect input number";
    private final static String ANY_KEY_MESSAGE = "Press Enter to continue...";

    private final static String NUMBER_MENU_MESSAGE = "Please enter the Number of car";
    private final static String COLOR_MENU_MESSAGE = "Please enter the Color of car";
    private final static String YEAR_MENU_MESSAGE = "Please enter the range of year (from and to)";
    private final static String NUMBER_PART_MENU_MESSAGE = "Please enter the part of the Number";

    private Scanner scanner;
    private CarService carService;

    public InputService(InputStream inputStream, CarService carService) {
        this.scanner = new Scanner(inputStream);
        this.carService = carService;
    }

    public void processMenu() throws IOException {
        int choiseNumber;
        while (true) {
            System.out.println(MAIN_MENU_MESSAGE);
            choiseNumber = scanner.nextInt();
            switch (choiseNumber) {
                case 0: {
                    return;
                }
                case 1: {
                    findCarsByTheNumber();
                    pressAnyKey();
                    break;
                }
                case 2: {
                    findCarsByTheColor();
                    pressAnyKey();
                    break;
                }
                case 3: {
                    findCarsByTheNumperPart();
                    pressAnyKey();
                    break;
                }
                case 4: {
                    findCarsByTheYearRange();
                    pressAnyKey();
                    break;
                }
                default: {
                    System.out.println(INCORRECT_NUMBER_MESSAGE);
                    pressAnyKey();
                }
            }
        }
    }

    public void destroy() {
        scanner.close();
    }

    private void printCars(List<Car> cars) {
         for (Car car : cars) {
             System.out.println(car);
         }
    }

    private void findCarsByTheNumber() {
        System.out.println(NUMBER_MENU_MESSAGE);
        String number = scanner.next();
        CarFilter filter = new CarNumberFilter(number);
        printCars(carService.findCars(filter));
    }

    private void findCarsByTheColor() {
        System.out.println(COLOR_MENU_MESSAGE);
        String color = scanner.next();
        CarFilter filter = new CarColorFilter(color);
        printCars(carService.findCars(filter));
    }

    private void findCarsByTheYearRange() {
        System.out.println(YEAR_MENU_MESSAGE);
        Integer yearFrom = scanner.nextInt();
        Integer yearTo = scanner.nextInt();
        CarFilter filter = new CarYearBetweenFilter(yearFrom, yearTo);
        printCars(carService.findCars(filter));
    }

    private void findCarsByTheNumperPart() {
        System.out.println(NUMBER_PART_MENU_MESSAGE);
        String number = scanner.next();
        CarFilter filter = new CarNumberContainsFilter(number);
        printCars(carService.findCars(filter));
    }

    private void pressAnyKey() throws IOException {
        System.out.println(ANY_KEY_MESSAGE);
        System.in.read();
    }
}
