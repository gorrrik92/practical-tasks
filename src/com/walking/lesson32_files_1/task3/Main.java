package com.walking.lesson32_files_1.task3;

import com.walking.lesson31_io_streams.model.Car;
import com.walking.lesson32_files_1.task3.model.CarRepository;

import java.io.IOException;
import java.util.Scanner;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static final String FILE_PATH = "./resource/files/lesson32/cars.txt";
    public static final String FIELD_DELIMETER = "_";

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository(FILE_PATH, FIELD_DELIMETER);
        Scanner sc = new Scanner(System.in);
        int choiseNumber;
        try {
            while (true) {
                showMainMenu();
                choiseNumber = sc.nextInt();
                switch (choiseNumber) {
                    case 0: {
                        sc.close();
                        return;
                    }
                    case 1: {
                        readAndShowCatalog(carRepository);
                        pressAnyKey();
                        break;
                    }
                    case 2: {
                        addNewCar(carRepository, sc);
                        pressAnyKey();
                        break;
                    }
                    case 3: {
                        deleteExistCar(carRepository, sc);
                        pressAnyKey();
                        break;
                    }
                    case 4: {
                        updateExistCar(carRepository, sc);
                        pressAnyKey();
                        break;
                    }
                    default: {
                        System.out.println("Incorrect input number");
                        pressAnyKey();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            sc.close();
        }
    }

    public static void showMainMenu() {
        System.out.println("Available menu:");
        System.out.println("1 - read carCatalog file and show it");
        System.out.println("2 - add new Car into carCatalog");
        System.out.println("3 - delete some Car from carCatalog");
        System.out.println("4 - update some Car in the carCatalog");
        System.out.println("0 - exit");
    }

    public static void readAndShowCatalog(CarRepository carRepository) {
        if (carRepository.readCarCatlog())
            System.out.println(carRepository.showCarCatalog());
    }

    public static void addNewCar(CarRepository carRepository, Scanner sc) {
        System.out.println("Please enter the data for new car");
        System.out.println("Number:");
        String number = sc.next();
        System.out.println("Year:");
        Integer year = sc.nextInt();
        System.out.println("Color:");
        String color = sc.next();
        System.out.println("IsActual:");
        Boolean isActual = sc.nextBoolean();
        carRepository.addNewCar(number, year, color, isActual);
    }

    public static void deleteExistCar(CarRepository carRepository, Scanner sc) {
        System.out.println("Enter the index of car which you want to delete:");
        int number = sc.nextInt();
        if (!carRepository.deleteCar(number)) {
            System.out.println("There is no related Car.");
        }
    }

    public static void updateExistCar(CarRepository carRepository, Scanner sc) {
        System.out.println("Please enter the index for updated car");
        int index = sc.nextInt();
        System.out.println("New color:");
        String color = sc.next();
        System.out.println("New IsActual:");
        Boolean isActual = sc.nextBoolean();
        carRepository.updateCar(index, color, isActual);
    }

    private static void pressAnyKey() throws IOException {
        System.out.println("Press Enter to continue...");
        System.in.read();
    }
}
