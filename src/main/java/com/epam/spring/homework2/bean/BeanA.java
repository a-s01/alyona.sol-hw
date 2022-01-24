package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean {
    private String name;
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
