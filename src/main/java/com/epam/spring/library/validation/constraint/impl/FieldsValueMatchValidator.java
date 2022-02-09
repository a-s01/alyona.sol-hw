package com.epam.spring.library.validation.constraint.impl;

import com.epam.spring.library.validation.constraint.FieldsValueMatch;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class FieldsValueMatchValidator
        implements ConstraintValidator<FieldsValueMatch, Object> {
    private String field;
    private String otherField;

    @Override
    public void initialize(FieldsValueMatch constraint) {
        this.field = constraint.field();
        this.otherField = constraint.otherField();
    }

    @Override
    public boolean isValid(Object o,
                           ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(field);
        Object otherFieldValue =
                new BeanWrapperImpl(o).getPropertyValue(otherField);

        if (Objects.isNull(fieldValue)) {
            return Objects.isNull(otherFieldValue);
        }

        return fieldValue.equals(otherFieldValue);
    }
}
