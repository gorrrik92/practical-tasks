package com.walking.lesson52_stream_creation.task2_iterate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Не используйте Stream.limit()
 */
public class Main {
    private static final String DATE_FORMATTER = "dd.MM.yyyy";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDateTime currentDate = LocalDateTime.now();
        Stream.iterate(currentDate.minusDays(currentDate.getDayOfMonth()-1), d -> (d.getMonthValue() == currentDate.getMonthValue()), d -> d.plusDays(1))
                .forEach(d -> System.out.println(d.format(formatter)));
    }
}
