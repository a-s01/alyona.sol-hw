package com.epam.spring.homework1.config;

import com.epam.spring.homework1.other.OtherBeanA;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = OtherBeanA.class)
@Import(PetConfig.class)
public class OtherConfig {
}
