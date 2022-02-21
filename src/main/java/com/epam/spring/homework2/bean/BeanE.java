package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@ValidationRequired
public class BeanE {

    @IsNotNull
    private String name;

    @IsInRange(fromIncluding = 1)
    private int value;

    public BeanE() {
        System.out.println("beanE: object creation");
    }

    @PostConstruct
    public void postConstruct() {
        if (name == null) {
            name = "default";
        }

        if (value == 0) {
            value = 100;
        }
        System.out.println("beanE: postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("beanE: preDestroy()");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
