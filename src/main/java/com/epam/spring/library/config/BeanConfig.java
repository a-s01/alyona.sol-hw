package com.epam.spring.library.config;

import com.epam.spring.library.model.Language;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("config")
@Getter
@Setter
public class BeanConfig {
    private List<String> languages;
    private String primaryLanguage;

    @Bean
    public List<Language> supportedLanguages() {
        // implementation is prospective subject to change in database
        // supported version of homework. For now, it's emulates getting
        // supported languages from database on startup
        List<Language> list = new ArrayList<>(languages.size());
        int i = 1;
        for (String s : languages) {
            Language lang = Language.builder().id(i++).code(s).build();
            list.add(lang);
        }
        return list;
    }

    @Bean
    @DependsOn("supportedLanguages")
    public Language defaultLanguage() {
        // same as above, will be changed in next iteration of homework
        return supportedLanguages().stream()
                                   .filter(lang -> lang.getCode()
                                                       .equals(primaryLanguage))
                                   .findFirst()
                                   .orElseThrow(IllegalArgumentException::new);
    }
}
