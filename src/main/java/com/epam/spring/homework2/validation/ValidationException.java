package com.epam.spring.homework2.validation;

public class ValidationException extends Exception {
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
