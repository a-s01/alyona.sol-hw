package com.epam.spring.library.repository.impl;

import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.AuthorTranslation;
import com.epam.spring.library.repository.AuthorTranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * I would like to implement custom repository in educational purpose
 */
@Repository
@RequiredArgsConstructor
class AuthorTranslationRepositoryImpl
        implements AuthorTranslationRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<AuthorTranslation> getOptionalTranslationFor(Author author,
                                                                 String langCode) {
        return entityManager.createQuery("SELECT tr FROM AuthorTranslation tr"
                                         + " JOIN tr.language l"
                                         + " JOIN tr.author a"
                                         + " WHERE a.id = :authorId "
                                         + " AND"
                                         + " l.code = :langCode",
                                         AuthorTranslation.class)
                            .setParameter("authorId", author.getId())
                            .setParameter("langCode", langCode)
                            .getResultStream()
                            .findAny();
    }
}
