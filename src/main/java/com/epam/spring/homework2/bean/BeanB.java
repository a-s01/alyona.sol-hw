package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanB extends BaseBean {

    public BeanB(String name, int value) {
        super(name, value);
        System.out.println("beanB: object creation");
    }

    public void anotherInitB() {
        System.out.println("beanB: anotherInitB()");
    }
}
