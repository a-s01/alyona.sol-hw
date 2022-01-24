package com.epam.spring.homework2.validation.impl;

import com.epam.spring.homework2.validation.ValidationException;
import com.epam.spring.homework2.validation.Validator;

import java.lang.reflect.Field;

/**
 * Validate fields marked as @IsNotNull
 * @see com.epam.spring.homework2.validation.annotation.IsNotNull
 */
public class NotNullValidator implements Validator {

    @Override
    public void validate(Field field, Object obj) throws ValidationException {
        field.setAccessible(true);
        try {
            if (field.get(obj) == null) {
                throw new ValidationException("validation error: field " + field.getName() + "@" + obj + " is null");
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }
}
