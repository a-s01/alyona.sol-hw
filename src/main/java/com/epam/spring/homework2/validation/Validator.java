package com.epam.spring.homework2.validation;

import java.lang.reflect.Field;

public interface Validator {
    void validate(Field field, Object obj) throws ValidationException;
}
