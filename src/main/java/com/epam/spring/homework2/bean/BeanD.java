package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanD extends BaseBean {

    public BeanD(String name, int value) {
        super(name, value);
        System.out.println("beanD: object creation");
    }
}
