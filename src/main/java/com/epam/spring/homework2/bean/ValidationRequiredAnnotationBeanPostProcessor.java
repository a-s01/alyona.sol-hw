package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.ValidationException;
import com.epam.spring.homework2.validation.Validator;
import com.epam.spring.homework2.validation.ValidatorFactory;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * NOTE: Implementing some ValidationRequired interface with getters in beans would be more lightweight and easy, but
 * I did more abstract solution with annotation post processor for educational purpose
 */
@Component
public class ValidationRequiredAnnotationBeanPostProcessor implements BeanPostProcessor {
    /**
     * Validation place is after all init methods, so postProcessAfterInitialization method will do it, and
     * postProcessAfterInitialization will save for it all beans required validation.
     */
    private final Map<String, Map<Field, Validator>> beansToValidate = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        ValidationRequired beanValidationRequired = bean.getClass().getAnnotation(ValidationRequired.class);

        if (beanValidationRequired != null) {
            Map<Field, Validator> fieldValidatorMap = new HashMap<>();

            for (Field field : bean.getClass().getDeclaredFields()) {
                for (Annotation annotation : field.getAnnotations()) {
                    ValidationRequired validationRequired = annotation.annotationType()
                            .getDeclaredAnnotation(ValidationRequired.class);

                    if (validationRequired != null) {
                        fieldValidatorMap.put(field, ValidatorFactory.getValidator(annotation));
                    }
                }
            }
            beansToValidate.put(beanName, fieldValidatorMap);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beansToValidate.containsKey(beanName)) {
            for (Map.Entry<Field, Validator> fieldValidatorEntry : beansToValidate.get(beanName).entrySet()) {
                try {
                    Field field = fieldValidatorEntry.getKey();
                    fieldValidatorEntry.getValue().validate(field, bean);
                } catch (ValidationException e) {
                    System.out.println(this.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        }

        return bean;
    }
}
