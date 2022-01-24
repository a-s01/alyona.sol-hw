package com.epam.spring.homework1.config;

import com.epam.spring.homework1.beans.BeanA;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = BeanA.class)
@Import(OtherConfig.class)
public class BeanConfig {
}
