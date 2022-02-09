package com.epam.spring.library.validation.constrain.impl;

import com.epam.spring.library.validation.constrain.PublicationYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class PublicationYearValidator
        implements ConstraintValidator<PublicationYear, Integer> {
    private int begin;

    @Override
    public void initialize(PublicationYear constraint) {
        this.begin = constraint.beginIncluding();
    }

    @Override
    public boolean isValid(Integer year,
                           ConstraintValidatorContext constraintValidatorContext) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= begin && year <= currentYear;
    }
}
