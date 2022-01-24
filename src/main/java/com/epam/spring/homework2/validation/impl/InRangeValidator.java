package com.epam.spring.homework2.validation.impl;

import com.epam.spring.homework2.validation.ValidationException;
import com.epam.spring.homework2.validation.Validator;

import java.lang.reflect.Field;

/**
 * Validates fields marked @IsInRange
 * @see com.epam.spring.homework2.validation.annotation.IsInRange
 */
public class InRangeValidator implements Validator {
    private final int from;
    private final int to;

    public InRangeValidator(int fromIncluding, int toIncluding) {
        from = fromIncluding;
        to = toIncluding;
    }

    @Override
    public void validate(Field field, Object obj) throws ValidationException {
        field.setAccessible(true);
        try {
            Object value = field.get(obj);
            if (value instanceof Number) {
                int intValue = ((Number) value).intValue();
                if (intValue > to || intValue < from) {
                    throw new ValidationException("field " + field.getName() + "@" + obj +
                            " is out of range [" + from + ", " + to + "]");
                }
            } else {
                throw new ValidationException("field " + field.getName() + "@" + obj + " is not numerical");
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }
}
