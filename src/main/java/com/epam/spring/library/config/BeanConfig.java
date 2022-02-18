package com.epam.spring.library.config;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.LanguageRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ConfigurationProperties("config")
@Getter
@Setter
public class BeanConfig {
    private String primaryLanguage;
    private int keepPeriod;
    private String messageFile;

    @Bean
    public Language defaultLanguage(LanguageRepository languageRepository) {
        return languageRepository.getLanguage(primaryLanguage);
    }

    @Bean
    public Book bookDefaults() {
        Book defaults = new Book();
        defaults.setKeepPeriod(keepPeriod);
        return defaults;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:" + messageFile);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
