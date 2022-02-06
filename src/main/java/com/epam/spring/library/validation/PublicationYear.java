package com.epam.spring.library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PublicationYearValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublicationYear {

    String message() default "Book publication year must be in range ["
                             + PublicationYearValidator.FIRST_PRINTED_BOOK_YEAR
                             + ", current year]";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
