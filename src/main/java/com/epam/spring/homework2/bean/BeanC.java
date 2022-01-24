package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.factory.annotation.Value;

@ValidationRequired
public class BeanC {

    @IsNotNull
    @Value("${beanC.name}")
    private String name;

    @IsInRange(fromIncluding = 1)
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
