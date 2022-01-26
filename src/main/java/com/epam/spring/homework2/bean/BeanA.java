package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ValidationRequired
public class BeanA implements InitializingBean, DisposableBean {

    @IsNotNull
    private String name;

    @IsInRange(fromIncluding = 1)
    private int value;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public BeanA() {
        System.out.println("beanA: object creation");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("beanA: afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("beanA: destroy()");
    }
}
