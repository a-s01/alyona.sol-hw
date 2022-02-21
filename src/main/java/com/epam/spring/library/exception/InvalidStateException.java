package com.epam.spring.library.exception;

public class InvalidStateException extends ServiceException {

    public InvalidStateException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR;
    }
}
