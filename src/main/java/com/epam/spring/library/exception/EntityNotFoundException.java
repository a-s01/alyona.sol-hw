package com.epam.spring.library.exception;

public class EntityNotFoundException extends ServiceException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATA_ACCESS_ERROR;
    }
}
