package com.epam.spring.library.exception;

public class EntityAlreadyExistsException extends ConflictException {

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATA_ACCESS_ERROR;
    }
}
