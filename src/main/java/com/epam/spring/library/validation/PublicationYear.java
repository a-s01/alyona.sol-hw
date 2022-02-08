package com.epam.spring.library.validation;

import com.epam.spring.library.validation.impl.PublicationYearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PublicationYearValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublicationYear {

    String message() default "{book.publication.year.invalid}";

    int beginIncluding() default 868;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
