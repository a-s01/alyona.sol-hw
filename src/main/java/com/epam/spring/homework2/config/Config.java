package com.epam.spring.homework2.config;

import com.epam.spring.homework2.bean.BeanA;
import com.epam.spring.homework2.bean.BeanB;
import com.epam.spring.homework2.bean.BeanC;
import com.epam.spring.homework2.bean.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import(OtherConfig.class)
@PropertySource("application.properties")
@ComponentScan(basePackageClasses = BeanA.class)
public class Config {

    @Bean(initMethod = "initD", destroyMethod = "destroyD")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "initB", destroyMethod = "destroyB")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "initC", destroyMethod = "destroyC")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }
}
