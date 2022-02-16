package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Optional<Language> findByCode(String code);

    default Language getLanguage(String code) {
        return findByCode(code).orElseThrow(() -> new EntityNotFoundException(
                "Language with code " + code + " doesn't exists"));
    }
}
