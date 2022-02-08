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

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD(@Value("${beanD.name}") String beanDName,
                       @Value("${beanD.value}") int beanDValue) {
        return new BeanD(beanDName, beanDValue);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB(@Value("${beanB.name}") String beanBName,
                       @Value("${beanB.value}") int beanBValue) {
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC beanC(@Value("${beanC.name}") String beanCName,
                       @Value("${beanC.value}") int beanCValue) {
        return new BeanC(beanCName, beanCValue);
    }
}
