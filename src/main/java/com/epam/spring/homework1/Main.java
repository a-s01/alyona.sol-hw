package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeanConfig;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

        Pet pet = ctx.getBean(Pet.class);
        pet.printPets();
    }
}
