package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanC extends BaseBean {

    public BeanC(String name, int value) {
        super(name, value);
        System.out.println("beanC: object creation");
    }
}
