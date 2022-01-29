package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanD {

    @IsNotNull
    private final String name;

    @IsInRange(fromIncluding = 1)
    private final int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
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
