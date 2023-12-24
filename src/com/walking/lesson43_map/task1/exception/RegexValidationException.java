package com.walking.lesson43_map.task1.exception;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String str, String regex) {
        super(String.format("%s not matches to '%s'", str, regex));
    }
}