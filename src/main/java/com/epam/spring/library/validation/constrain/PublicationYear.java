package com.epam.spring.library.validation.constrain;

import com.epam.spring.library.validation.constrain.impl.PublicationYearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PublicationYearValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublicationYear {

    String message() default "{book.publication.year.invalid}";

    /**
     * The default value is the first printed book publish year according to
     * wikipedia - https://en.wikipedia.org/wiki/History_of_books
     */
    int beginIncluding() default 868;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
