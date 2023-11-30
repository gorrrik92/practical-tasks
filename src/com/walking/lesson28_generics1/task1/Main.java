package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.model.PowNumber;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        PowNumber<Short> shortNumber = new PowNumber<Short>((short) 10);
        PowNumber<Byte> byteNumber = new PowNumber<Byte>((byte) 100);
        PowNumber<Integer> intNumber = new PowNumber<Integer>((int) 12);
        PowNumber<Double> doubleNumber = new PowNumber<Double>((double) 1000);

        System.out.println(shortNumber.powMethod(2));
        System.out.println(byteNumber.powMethod(2));
        System.out.println(intNumber.powMethod(2));
        System.out.println(doubleNumber.powMethod(2));
    }
}
