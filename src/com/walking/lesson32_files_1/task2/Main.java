package com.walking.lesson32_files_1.task2;

import com.walking.lesson31_io_streams.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.IntSummaryStatistics;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static final String FILE_PATH = "./resource/files/lesson32/cars.txt";
    public static final String FIELD_DELIMETER = "_";

    public static void main(String[] args) {
        try(FileInputStream fin=new FileInputStream(FILE_PATH))
        {
            StringBuilder strLine= new StringBuilder();
            int i;
            while((i=fin.read())!=-1){
                char nextChar= (char) i;
                if (nextChar == '\n') {
                    Car car = parseCarLine(strLine.toString());
                    System.out.println(car);
                    strLine= new StringBuilder();
                } else {
                    strLine.append(nextChar);
                }
            }
        }  catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static Car parseCarLine(String carLine) throws IllegalArgumentException {
        String[] elements = carLine.split(FIELD_DELIMETER);
        if (elements.length == 4) {
            String number = elements[0];
            Integer year = Integer.parseInt(elements[1]);
            String color = elements[2];
            Boolean isActual = Boolean.parseBoolean(elements[3]);
            return new Car(number, year, color, isActual);
        } else {
            throw new IllegalArgumentException(String.format("Incorrect format of Car line: %s", carLine));
        }
    }
}
