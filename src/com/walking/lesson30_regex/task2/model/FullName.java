package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String firstName;
    private final String lastName;
    private final String surName;

    public FullName(String firstName, String lastName, String surName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
