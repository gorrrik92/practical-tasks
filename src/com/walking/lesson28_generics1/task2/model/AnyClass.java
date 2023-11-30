package com.walking.lesson28_generics1.task2.model;

public class AnyClass<T>{
    private T value;

    public AnyClass(T value) {
        this.value = value;
    }

    public boolean checkNull() {
        return (value == null);
    }
}
