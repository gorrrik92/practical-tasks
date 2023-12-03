package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.model.FullName;

import java.io.InvalidObjectException;
import java.util.Scanner;

/**
 * Реализуйте метод для работы с ФИО.
 * Входным параметром должна являться строка,
 * содержащая русскоязычное ФИО.
 * Фамилия, имя и отчество должны начинаться с прописной буквы
 * и быть разделены пробелами.
 * Фамилия может быть двойной и писаться через дефис
 * (каждая часть фамилии начинается с прописной буквы).
 * Если строка валидна – верните ФИО, обернутое в класс «Полное имя»,
 * содержащий фамилию, имя и отчество.
 * Если невалидна – бросьте из метода исключение, указывающее на ошибку валидации.
 */
public class Main {
    private static final String NAME_MASK = "^[А-Я&&[^ЬЪ]][а-я]*$";
    private static final String NAMES_DELIMETER = " ";
    private static final String LAST_NAMES_DELIMETER = "-";

    public static void main(String[] args) throws InvalidObjectException {
        System.out.println("Enter fullName in the correct format");;
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        sc.close();
        System.out.printf("FullName is correct: %s", checkAndReturnValidName(fullName).toString());
    }

    private static FullName checkAndReturnValidName(String fullName) throws InvalidObjectException {
        String[] names= fullName.split(NAMES_DELIMETER);
        if (names.length == 3 && isValidName(names[1]) && isValidLastName(names[0]) && isValidName(names[2])) {
            return new FullName(names[1], names[0], names[2]);
        } else {
            throw new InvalidObjectException("Некорректный формат имени");
        }
    }

    private static boolean isValidName(String name) {
        return name.matches(NAME_MASK);
    }

    private static boolean isValidLastName(String name) {
        String[] lastNames = name.split(LAST_NAMES_DELIMETER);
        boolean isLastNameValid = true;
        if (lastNames.length <= 2) {
            for (String lastName : lastNames) {
                isLastNameValid = isLastNameValid && isValidName(lastName);
            }
        }  else {
            isLastNameValid = false;
        }
        return isLastNameValid;
    }
}
