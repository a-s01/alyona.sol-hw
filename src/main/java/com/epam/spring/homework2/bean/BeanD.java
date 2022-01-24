package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.factory.annotation.Value;

@ValidationRequired
public class BeanD {

    @IsNotNull
    @Value("${beanD.name}")
    private String name;

    @IsInRange(fromIncluding = 1)
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
