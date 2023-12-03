package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.RegexValidationException;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson26_string_types/task2/Main.java">...</a>
 * Теперь слова в исходном массиве могут быть разделены несколькими пробелами,
 * а также знаками табуляции и иными пробельными символами.
 * Словами считаются лишь подстроки,
 * состоящие из буквенных символов или содержащие в середине слова один
 * или несколько дефисов, но не более одного подряд.
 * При наличии в исходной строке невалидных символов или некорректном использовании допустимых,
 * должно быть выброшено исключение.
 */
public class Main {
    private static final String STRING_DELIMETER_MASK = "[\\t \\s]+";
    private static final String WORD_MASK = "[a-zA-ZА-Яа-я]+";
    private static final String WORD_DELIMETER = "-";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim() //обрезаем пробелы в начале и коне введенной строки
                .toLowerCase() //приводим все к нижнему регистру, чтобы слова в разном регистре не посчитались по отдельности
                .split(STRING_DELIMETER_MASK); //разбиваем строку на массив, разделенный по " "

        scanner.close();

        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            // Каждое слово в массиве сравниваем с предыдущими словами того же массива.
            // Если слово эквивалентно одному из предыдущих - оно не уникально
            validateWord(words[i]);
            int j = 0;
            boolean isUnique = true;
            while (j < i && isUnique) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                } else {
                    j++;
                }
            }

            if (isUnique) {
                counter++;
            }
        }

        System.out.printf("Found %d unique words\n", counter);
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
