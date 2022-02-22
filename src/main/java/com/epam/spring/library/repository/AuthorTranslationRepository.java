package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.AuthorTranslation;

import java.util.Optional;

public interface AuthorTranslationRepository {

    Optional<AuthorTranslation> getOptionalTranslationFor(Author author,
                                                          String langCode);

    default AuthorTranslation getTranslationFor(Author author,
                                                String langCode) {
        return getOptionalTranslationFor(author, langCode).orElseThrow(
                () -> new EntityNotFoundException(
                        "There's no name " + "translation for " + "author id#"
                        + author.getId() + " " + "in language " + langCode));
    }
}
