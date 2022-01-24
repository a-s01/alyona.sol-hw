package com.epam.spring.homework2.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {
    private String name;
    private int value;

    public BeanE() {
        System.out.println("beanE: object creation");
    }

    @PostConstruct
    public void postConstruct() {
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
