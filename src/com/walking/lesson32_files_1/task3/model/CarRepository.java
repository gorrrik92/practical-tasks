package com.walking.lesson32_files_1.task3.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CarRepository {
    private Car[] carCatalog;
    private String filePath;
    private String fieldsDelimeter;

    public CarRepository(String filePath, String fieldsDelimeter) {
        this.fieldsDelimeter = fieldsDelimeter;
        this.filePath = filePath;
    }

    public Car getCar(int i) {
        if (i > carCatalog.length || i < 0) {
            return null;
        } else {
            return carCatalog[i-1];
        }
    }

    public boolean addNewCar(String number, Integer year, String color, boolean isActual) {
        readCarCatlog();
        Car[] newCatalog = new Car[carCatalog.length+1];
        for(int j = 0; j < carCatalog.length; j++) {
            newCatalog[j] = carCatalog[j];
        }
        newCatalog[carCatalog.length] = new Car(number, year, color, isActual);
        carCatalog  = newCatalog;
        return writeCarCatalog();
    }

    public boolean deleteCar(int i) {
        readCarCatlog();
        if (i > carCatalog.length || i < 0) {
            return false;
        } else {
            Car[] newCatalog = new Car[carCatalog.length-1];
            for(int j = 0; j < i; j++) {
                newCatalog[j] = carCatalog[j];
            }
            for(int j = i+1; j < carCatalog.length; j++) {
                newCatalog[j-1] = carCatalog[j];
            }
            carCatalog  = newCatalog;
            return writeCarCatalog();
        }
    }

    public boolean updateCar(int i, String color, boolean isActual) {
        readCarCatlog();
        Car car = getCar(i);
        if (car == null) {
            return false;
        }
        car.setActualTechnicalInspection(isActual);
        car.setColor(color);
        return writeCarCatalog();
    }

    public String showCarCatalog() {
        StringBuilder str = new StringBuilder();
        int i = 1;
        for (Car car : carCatalog) {
            str.append("-------------------\n");
            str.append("Car #"+i++);
            str.append("\n");
            str.append(car.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public boolean readCarCatlog() {
        if (carCatalog != null) {
            return true;
        }
        StringBuilder fileString= new StringBuilder();
        try(FileInputStream fin=new FileInputStream(filePath))
        {
            int i;
            while((i=fin.read())!=-1){
                char nextChar= (char) i;
                fileString.append(nextChar);
            }
            parseFileString(fileString.toString());
            return true;
        }  catch (Exception ex){
            System.out.println("Error on file reading: " + ex);
            return false;
        }
    }

    private boolean writeCarCatalog() {
        try(FileOutputStream fout=new FileOutputStream(filePath))
        {
            for(Car car : carCatalog) {
                fout.write(carToString(car).getBytes());
            }
            return true;
        }  catch (Exception ex){
            System.out.println("Error on file saving: " + ex);
            return  false;
        }

    }

    private String carToString(Car car) {
        return String.format("%s%s%d%s%s%s%b\n", car.getNumber(), fieldsDelimeter, car.getYear(), fieldsDelimeter, car.getColor(), fieldsDelimeter, car.isActualTechnicalInspection());
    }

    private void parseFileString(String fileString) {
        String[] carLines = fileString.split("\\n");
        if (carLines.length > 0) {
            carCatalog = new Car[carLines.length];
            for (int i = 0; i < carLines.length; i++) {
                Car car = parseCarLine(carLines[i]);
                carCatalog[i] = car;
            }
        }
    }

    private Car parseCarLine(String carLine) throws IllegalArgumentException {
        String[] elements = carLine.split(fieldsDelimeter);
        if (elements.length == 4) {
            String number = (elements[0] == "null") ? null : elements[0];
            Integer year = Integer.parseInt(elements[1]);
            String color = elements[2] == "null" ? null : elements[2];
            Boolean isActual = Boolean.parseBoolean(elements[3]);
            return new Car(number, year, color, isActual);
        } else {
            throw new IllegalArgumentException(String.format("Incorrect format of Car line: %s", carLine));
        }
    }

}
