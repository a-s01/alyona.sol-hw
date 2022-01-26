package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.annotation.IsInRange;
import com.epam.spring.homework2.validation.annotation.IsNotNull;
import com.epam.spring.homework2.validation.annotation.ValidationRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@ValidationRequired
public class BeanF {

    @IsNotNull
    private final String name;

    @IsInRange(fromIncluding = 1)
    private final int value;
    
    public BeanF(@Value("${beanF.name:default}") String name, @Value("${beanF.value:100}") int value) {
        this.name = name;
        this.value = value;
        System.out.println("beanF: object creation");
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
