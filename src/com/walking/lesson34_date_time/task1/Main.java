package com.walking.lesson34_date_time.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    private static final String DATE_FORMATTER = "dd.MM.yyyy HH:mm:ss";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        System.out.printf("Enter the date in the format %s\n", DATE_FORMATTER);
        Scanner sc = new Scanner(System.in);
        String dateString = sc.nextLine();

        LocalDateTime parsedDate = parsedDate(dateString, formatter);
        System.out.println(parsedDate);
    }

    private static LocalDateTime parsedDate(String str, DateTimeFormatter formatter) {
        return LocalDateTime.parse(str, formatter);
    }
}
