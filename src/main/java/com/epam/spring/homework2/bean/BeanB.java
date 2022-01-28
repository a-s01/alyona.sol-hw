package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanB {

    @IsNotNull
    private final String name;

    @IsInRange(fromIncluding = 1)
    private final int value;

    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanB: object creation");
    }

    public void initB() {
        System.out.println("beanB: initB()");
    }

    public void destroyB() {
        System.out.println("beanB: destroyB()");
    }

    public void anotherInitB() {
        System.out.println("beanB: anotherInitB()");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
