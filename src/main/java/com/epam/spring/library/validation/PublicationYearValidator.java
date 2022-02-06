package com.epam.spring.library.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class PublicationYearValidator implements ConstraintValidator<PublicationYear, Integer> {
    public static final int FIRST_PRINTED_BOOK_YEAR = 868;

    @Override
    public boolean isValid(Integer year,
                           ConstraintValidatorContext constraintValidatorContext) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= FIRST_PRINTED_BOOK_YEAR && year <= currentYear;
    }
}
