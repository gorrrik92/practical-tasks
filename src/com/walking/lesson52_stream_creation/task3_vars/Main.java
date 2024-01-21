package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * Каждый Stream, возвращенный из метода, должен быть сохранен в отдельную переменную.
 */
public class Main {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        Stream<String> dates = Stream.empty();
        for (int i=1; i<=12; i++) {
            dates = Stream.concat(dates, getMothDatesStream(i));
        }
        dates.forEach(System.out::println);
    }

    private static Stream<String> getMothDatesStream(int month) {
        LocalDate startDate = LocalDate.now().withMonth(month).withDayOfMonth(1);
        int dayCount = startDate.getMonth().length(startDate.isLeapYear());
        return Stream.iterate(startDate, d -> d.plusDays(1))
                .limit(dayCount)
                .map(d -> d.format(formatter));
    }
}
