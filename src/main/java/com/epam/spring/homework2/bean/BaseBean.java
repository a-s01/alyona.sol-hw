package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;

public abstract class BaseBean {
    @IsNotNull
    private final String name;

    @IsInRange(fromIncluding = 1)
    private final int value;

    protected BaseBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": init()");
    }

    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": destroy()");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "name='" + name
               + '\'' + ", value=" + value + '}';
    }
}
