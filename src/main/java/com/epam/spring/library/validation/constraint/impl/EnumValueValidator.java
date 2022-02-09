package com.epam.spring.library.validation.constraint.impl;

import com.epam.spring.library.validation.constraint.EnumValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class EnumValueValidator
        implements ConstraintValidator<EnumValue, String> {
    private Class<? extends Enum> targetEnum;
    private boolean allowNull;

    @Override
    public void initialize(EnumValue constraint) {
        targetEnum = constraint.of();
        allowNull = constraint.allowNull();
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext constraintValidatorContext) {

        return allowNull && Objects.isNull(value)
                || Arrays.stream(targetEnum.getEnumConstants())
                         .anyMatch(c -> c.name().equals(value));
        }
}
