package com.walking.lesson30_regex.task3.exception;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String str, String regex) {
        super(String.format("%s not matches to '%s'", str, regex));
    }
}