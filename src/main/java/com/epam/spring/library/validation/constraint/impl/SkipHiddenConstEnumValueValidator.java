package com.epam.spring.library.validation.constraint.impl;

import com.epam.spring.library.validation.constraint.EnumValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;


public class SkipHiddenConstEnumValueValidator extends CommonEnumValueValidator
        implements ConstraintValidator<EnumValue, Enum<?>> {

    @Override
    public void initialize(EnumValue constraint) {
        super.initialize(constraint);
    }

    @Override
    public boolean isValid(Enum value,
                           ConstraintValidatorContext constraintValidatorContext) {
        return super.nullIsValid(value)
               || Objects.nonNull(value) && super.isValid(value.name());
    }
}
