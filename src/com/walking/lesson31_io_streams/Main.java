package com.walking.lesson31_io_streams;

import com.walking.lesson31_io_streams.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Чтение данных с помощью System.in и приведение к примитивным типам или строкам
 */
public class Main {
    public static final String FILE_PATH = "./resource/cars.txt";
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
                System.out.print(cars.toString());
            }
        }  catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static byte[] carToString(Car car) {
        return String.format("%s %d %s %b\n", car.getNumber(), car.getYear(), car.getColor(), car.isActualTechnicalInspection()).getBytes();
    }
}
