package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeanConfig;
import com.epam.spring.homework1.other.OtherBeanC;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

        Pet pet = ctx.getBean(Pet.class);
        pet.printPets();

        // item 10
        // this uses @Primary bean
        Cheetah cheetah = ctx.getBean(Cheetah.class);
        System.out.println("\n" + cheetah.hashCode());

        // this uses method with name myCheetah from PetConfig
        Cheetah cheetah2 = (Cheetah) ctx.getBean("myCheetah");
        System.out.println(cheetah2.hashCode());

        // and they are different objects (see hashCode) because of different ways of calling them
    }
}
