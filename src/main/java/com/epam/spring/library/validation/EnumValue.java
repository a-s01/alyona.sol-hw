package com.epam.spring.library.validation;

import com.epam.spring.library.validation.impl.EnumValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The annotated String field value must match one of the specified
 * enum's values. If allowNull() is true, a null value
 * is also considered to be valid.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface EnumValue {

    String message() default "{invalid.value}";

    boolean allowNull() default true;

    Class<? extends Enum> of();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
