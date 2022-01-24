package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.factory.annotation.Value;

@ValidationRequired
public class BeanB {

    @IsNotNull
    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    @IsInRange(fromIncluding = 1)
    private int value;

    public BeanB() {
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
