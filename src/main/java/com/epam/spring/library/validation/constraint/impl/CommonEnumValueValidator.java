package com.epam.spring.library.validation.constraint.impl;

import com.epam.spring.library.validation.constraint.EnumValue;
import io.swagger.v3.oas.annotations.Hidden;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

/**
 * Implements basic logic of EnumValueValidator
 */
public class CommonEnumValueValidator {
    private Class<? extends Enum> targetEnum;
    private boolean allowNull;

    protected CommonEnumValueValidator() {}

    public void initialize(EnumValue constraint) {
        targetEnum = constraint.of();
        allowNull = constraint.allowNull();
    }

    public boolean isValid(String value) {
        return Arrays.stream(targetEnum.getDeclaredFields())
                     .filter(f -> f.isEnumConstant() && !f.isAnnotationPresent(
                             Hidden.class))
                     .map(Field::getName)
                     .anyMatch(name -> Objects.equals(name, value));
    }

    public boolean nullIsValid(Object value) {
        return allowNull && Objects.isNull(value);
    }
}
