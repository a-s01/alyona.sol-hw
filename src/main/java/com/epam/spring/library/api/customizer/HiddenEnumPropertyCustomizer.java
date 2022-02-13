package com.epam.spring.library.api.customizer;

import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.PropertyCustomizer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class should do a good work leaving only not hidden enum values in
 * OpenApi Enum Schema automatically. Happened, it doesn't work for my DTO,
 * because I use strings not enums there. But I want to preserve this work for
 * future needs.
 */
@Component
public class HiddenEnumPropertyCustomizer implements PropertyCustomizer {

    /**
     * If an Enum has a value annotated by @Hidden, customizer will delete it
     * from Schema, therefore it won't be shown in OpenApi documentation.
     */
    @Override
    public Schema customize(Schema property, AnnotatedType type) {
        if (isAnEnum(type)) {
            property.setEnum(Arrays.stream(getDeclaredFields(type))
                                   .filter(this::isHiddenEnumConstant)
                                   .map(Field::getName)
                                   .collect(Collectors.toList()));
        }
        return property;
    }

    private boolean isAnEnum(AnnotatedType type) {
        return type.getType() instanceof JavaType
               && ((JavaType) type.getType()).getRawClass().isEnum();
    }

    private Field[] getDeclaredFields(AnnotatedType type) {
        return ((JavaType) type.getType()).getRawClass().getDeclaredFields();
    }

    private boolean isHiddenEnumConstant(Field f) {
        return f.isEnumConstant() && Objects.isNull(
                AnnotationUtils.findAnnotation(f, Hidden.class));
    }
}
