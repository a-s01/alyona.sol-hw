package com.epam.spring.library.validation;

import com.epam.spring.library.validation.impl.FieldsValueMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Class fields with names 'field' and 'otherField' must match
 */
@Documented
@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target(ElementType.TYPE)
@Repeatable(FieldsValueMatch.List.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {

    String message() default "{fields.do.not.match}";

    String field();

    String otherField();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
     @interface List {
        FieldsValueMatch[] value();
    }
}
