package com.epam.spring.library.validation.constraint.impl;

import com.epam.spring.library.validation.constraint.EnumValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringEnumValueValidator extends CommonEnumValueValidator
        implements ConstraintValidator<EnumValue, String> {

    @Override
    public void initialize(EnumValue constraint) {
        super.initialize(constraint);
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext constraintValidatorContext) {
        return super.nullIsValid(value) || super.isValid(value);
    }
}
