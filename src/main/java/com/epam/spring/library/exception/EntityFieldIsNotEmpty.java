package com.epam.spring.library.exception;

public class EntityFieldIsNotEmpty extends ConflictException {

    public EntityFieldIsNotEmpty(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR;
    }
}
