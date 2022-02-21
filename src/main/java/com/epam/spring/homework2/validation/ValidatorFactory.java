package com.epam.spring.homework2.validation;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.impl.InRangeValidator;
import com.epam.spring.homework2.validation.impl.NotNullValidator;

import java.lang.annotation.Annotation;

public class ValidatorFactory {
    /**
     * One NonNullValidator object can validate all the beans, so it's singleton candidate
     * @see NotNullValidator
     */
    private static Validator notNullValidator = new NotNullValidator();

    private ValidatorFactory() {}

    public static Validator getValidator(Annotation annotation) {
        if (annotation instanceof IsNotNull) {
            return notNullValidator;
        } else if (annotation instanceof IsInRange) {
            IsInRange inRange = (IsInRange) annotation;
            return new InRangeValidator(inRange.fromIncluding(), inRange.toIncluding());
        }

        throw new IllegalArgumentException("Unsupported annotation type " + annotation.getClass());
    }
}
