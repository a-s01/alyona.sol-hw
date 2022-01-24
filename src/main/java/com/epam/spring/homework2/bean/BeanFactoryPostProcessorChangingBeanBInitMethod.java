package com.epam.spring.homework2.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorChangingBeanBInitMethod implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanBDefinition = configurableListableBeanFactory.getBeanDefinition("beanB");
        beanBDefinition.setInitMethodName("anotherInitB");
        System.out.println(this.getClass().getSimpleName() + ": changed init method for beanB to anotherInitB");
    }
}
