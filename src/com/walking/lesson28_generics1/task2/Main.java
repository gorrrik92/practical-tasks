package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.AnyClass;

import java.util.Scanner;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        AnyClass<String> stringClass = new AnyClass<>("");
        AnyClass<Integer> intClass = new AnyClass<>(10);
        AnyClass<StringBuffer> bufferClass = new AnyClass<>(null);
        AnyClass<Scanner> scannerClass = new AnyClass<>(new Scanner(System.in));

        System.out.println(stringClass.checkNull());
        System.out.println(intClass.checkNull());
        System.out.println(bufferClass.checkNull());
        System.out.println(scannerClass.checkNull());

    }
}
