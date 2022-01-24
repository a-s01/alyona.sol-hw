package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    public BeanC() {
        System.out.println("beanC: object creation");
    }

    public void initC() {
        System.out.println("beanC: initC()");
    }

    public void destroyC() {
        System.out.println("beanC: destroyC()");
    }


    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
