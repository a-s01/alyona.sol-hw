package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public BeanD() {
        System.out.println("beanD: object creation");
    }

    public void initD() {
        System.out.println("beanD: initD()");
    }

    public void destroyD() {
        System.out.println("beanD: destroyD()");
    }


    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
