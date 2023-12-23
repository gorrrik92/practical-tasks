package com.walking.lesson41_set.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim() //обрезаем пробелы в начале и коне введенной строки
                .toLowerCase() //приводим все к нижнему регистру, чтобы слова в разном регистре не посчитались по отдельности
                .split(" "); //разбиваем строку на массив, разделенный по " "

        scanner.close();

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.printf("Found %d unique words\n", uniqueWords.size());
    }
}
