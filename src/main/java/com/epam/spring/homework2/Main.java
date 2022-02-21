package com.epam.spring.homework2;

import com.epam.spring.homework2.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("\nAll beans present in application context: ");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("- " + context.getBean(beanDefinitionName));
        }

        System.out.println("\nAll bean definitions present in application context: ");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("- " + context.getBeanDefinition(beanDefinitionName));
        }

        System.out.println("\nDestroying context...");
        context.close();
    }
}
