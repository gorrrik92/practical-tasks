package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    private static final String DATE_FORMATTER = "dd.MM.yyyy HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    public static void main(String[] args) {
        System.out.printf("Enter the date in the format %s\n", DATE_FORMATTER);
        Scanner sc = new Scanner(System.in);
        String dateString = sc.nextLine();

        LocalDateTime parsedDate = parsedDate(dateString, formatter);
        LocalDateTime currentDate = LocalDateTime.now();

        int flag = parsedDate.compareTo(currentDate);
        if (flag > 0) {
            System.out.println("time more than Now");
        } else if (flag < 0) {
            System.out.println("time less than Now");
        } else {
            System.out.println("time equals to Now");
        }
    }

    private static LocalDateTime parsedDate(String str, DateTimeFormatter formatter) {
        return LocalDateTime.parse(str, formatter);
    }
}
