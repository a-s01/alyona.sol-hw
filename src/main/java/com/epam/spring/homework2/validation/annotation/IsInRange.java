package com.epam.spring.homework2.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @IsInRange marked field must be numerical (primitive or wrapped, doesn't matter) and be in specified range
 * [fromIncluding, toIncluding]
 */
@ValidationRequired
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsInRange {

    int fromIncluding() default Integer.MIN_VALUE;
    int toIncluding() default Integer.MAX_VALUE;
}
