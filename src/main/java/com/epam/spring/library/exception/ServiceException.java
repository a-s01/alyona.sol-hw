package com.epam.spring.library.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(message: " + getMessage()
               + ", error type: " + getErrorType() + ")";
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR;
    }
}
