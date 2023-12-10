package com.walking.lesson32_files_1.task1;

import com.walking.lesson31_io_streams.model.Car;

import java.io.FileOutputStream;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static final String FILE_PATH = "./resource/files/lesson32/cars.txt";
    public static final String FIELD_DELIMETER = "_";
    private static Car[] cars = new Car[3];
    static {
        cars[0] = new Car("111", 2017, "blue", true);
        cars[1] = new Car("222", 2018, "green", true);
        cars[2] = new Car("333", 2000, "red", false);
    }
    public static void main(String[] args) {
        try(FileOutputStream fout=new FileOutputStream(FILE_PATH))
        {
            for(Car car : cars) {
                fout.write(carToString(car));
                System.out.println(car.toString());
            }
        }  catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static byte[] carToString(Car car) {
        return String.format("%s%s%d%s%s%s%b\n", car.getNumber(), FIELD_DELIMETER, car.getYear(), FIELD_DELIMETER, car.getColor(), FIELD_DELIMETER, car.isActualTechnicalInspection()).getBytes();
    }
}
