package com.walking.lesson43_map.task1;

import com.walking.lesson43_map.task1.exception.RegexValidationException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */
public class Main {
    private static final String STRING_DELIMETER_MASK = "[\\t \\s]+";
    private static final String WORD_MASK = "[a-zA-ZА-Яа-я]+";
    private static final String WORD_DELIMETER = "-";


    public static void main(String[] args) {
        Map<String, Integer> unigueWords = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim() //обрезаем пробелы в начале и коне введенной строки
                .toLowerCase() //приводим все к нижнему регистру, чтобы слова в разном регистре не посчитались по отдельности
                .split(STRING_DELIMETER_MASK); //разбиваем строку на массив, разделенный по " "

        scanner.close();

        for (String word : words) {
            // Каждое слово в массиве сравниваем с предыдущими словами того же массива.
            // Если слово эквивалентно одному из предыдущих - оно не уникально
            validateWord(word);

            if (unigueWords.containsKey(word)) {
                unigueWords.put(word, unigueWords.get(word)+1);
            }  else {
                unigueWords.put(word, 1);
            }
        }

        System.out.println("Found %d unique words");
        for (Map.Entry<String, Integer> entry : unigueWords.entrySet()) {
            System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
        }
    }

    private static void validateWord(String word) {
        if (word.contains("-")) {
            String[] subWords = word.split(WORD_DELIMETER);
            for (String subWord : subWords) {
                validateSimpleWord(subWord);
            }
        } else {
            validateSimpleWord(word);
        }
    }

    private static void validateSimpleWord(String word) {
        if (!word.matches(WORD_MASK)) {
            throw new RegexValidationException(word, WORD_MASK);
        }
    }
}