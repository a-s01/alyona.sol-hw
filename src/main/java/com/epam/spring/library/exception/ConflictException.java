package com.epam.spring.library.exception;

public class ConflictException extends ServiceException {
    public ConflictException(String message) {
        super(message);
    }
}
