package com.walking.lesson52_stream_creation.task2_limit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Используйте Stream.limit()
 */
public class Main {
    private static final String DATE_FORMATTER = "dd.MM.yyyy";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDate currentDate = LocalDate.now().withDayOfMonth(1);
        int dayCount = currentDate.getMonth().length(currentDate.isLeapYear());
        Stream.iterate(currentDate, d -> d.plusDays(1))
                .limit(dayCount)
                .map(d -> d.format(formatter))
                .forEach(System.out::println);
    }
}
