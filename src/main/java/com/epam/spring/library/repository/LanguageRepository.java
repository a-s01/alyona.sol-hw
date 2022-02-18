package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * This repository is a perfect candidate for showing usage of required @Query
 * annotation as it should implement only 2 methods. That's why it extends
 * base repository now.
 */
@Repository
public interface LanguageRepository
        extends org.springframework.data.repository.Repository<Language, Integer> {

    @Query("SELECT lang FROM Language as lang")
    List<Language> findAll();

    @Query("SELECT lang FROM Language as lang WHERE lang.code = :code")
    Language findByCode(@Param("code") String code);

    default Language getLanguage(String code) {
        Language lang = findByCode(code); // seems like Hibernate
        // default caching doesn't here, so I'll cache is by myself
        if (Objects.isNull(lang)) {
            throw new EntityNotFoundException(
                    "Language with code " + code + " doesn't exists");
        }
        return lang;
    }
}
