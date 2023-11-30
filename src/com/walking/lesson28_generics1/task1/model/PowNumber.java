package com.walking.lesson28_generics1.task1.model;

public class PowNumber <T extends Number>{
    private T num;

    public PowNumber(T num) {
        this.num = num;
    }

    public double powMethod(double pow) {
        return Math.pow(num.doubleValue(), pow);
    }
}
