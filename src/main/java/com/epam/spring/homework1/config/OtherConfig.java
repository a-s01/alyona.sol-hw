package com.epam.spring.homework1.config;

import com.epam.spring.homework1.other.OtherBeanA;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = OtherBeanA.class)
public class OtherConfig {
}
