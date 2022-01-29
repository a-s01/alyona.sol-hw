package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;

@ValidationRequired
public class BeanC {

    @IsNotNull
    private final String name;

    @IsInRange(fromIncluding = 1)
    private final int value;

    public BeanC(String name, int value) {
        this.name = name;
        this.value = value;
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
