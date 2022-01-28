package com.epam.spring.homework2.config;

import com.epam.spring.homework2.bean.BeanA;
import com.epam.spring.homework2.bean.BeanB;
import com.epam.spring.homework2.bean.BeanC;
import com.epam.spring.homework2.bean.BeanD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Import(OtherConfig.class)
@PropertySource("application.properties")
@ComponentScan(basePackageClasses = BeanA.class)
public class Config {

    @Value("${beanB.name}")
    private String beanBName;
    @Value("${beanB.value}")
    private int beanBValue;
    @Value("${beanC.name}")
    private String beanCName;
    @Value("${beanC.value}")
    private int beanCValue;
    @Value("${beanD.name}")
    private String beanDName;
    @Value("${beanD.value}")
    private int beanDValue;

    @Bean(initMethod = "initD", destroyMethod = "destroyD")
    public BeanD beanD() {
        return new BeanD(beanDName, beanDValue);
    }

    @Bean(initMethod = "initB", destroyMethod = "destroyB")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "initC", destroyMethod = "destroyC")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC(beanCName, beanCValue);
    }
}
