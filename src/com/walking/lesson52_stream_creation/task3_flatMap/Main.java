package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * В main() Stream должен быть лишь 1. Требует использования flatMap().
 */
public class Main {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        Stream.iterate(1, i -> ++i)
                .limit(12)
                .flatMap(i->getMothDatesStream(i))
                .forEach(System.out::println);
    }

    private static Stream<String> getMothDatesStream(int month) {
        LocalDate startDate = LocalDate.now().withMonth(month).withDayOfMonth(1);
        int dayCount = startDate.getMonth().length(startDate.isLeapYear());
        return Stream.iterate(startDate, d -> d.plusDays(1))
                .limit(dayCount)
                .map(d -> d.format(formatter));
    }

}
