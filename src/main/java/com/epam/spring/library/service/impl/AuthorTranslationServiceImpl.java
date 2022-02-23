package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.AuthorTranslationMapper;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.AuthorTranslation;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
class AuthorTranslationServiceImpl implements AuthorTranslationService {
    private final AuthorRepository repository;
    private final AuthorTranslationMapper mapper;

    @Override
    public Map<String, String> getAllAuthorNameTranslations(String name) {
        Author author = repository.getByName(name);
        return mapper.toDTO(author.getNameTranslations());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String translation) {
        Author author = repository.getByName(name);
        Optional<AuthorTranslation> existedTranslation =
                repository.getOptionalTranslationFor(author, langCode);

        if (existedTranslation.isPresent()) {
            existedTranslation.get().setName(translation);
        } else {
            author.addNameTranslation(
                    mapper.toAuthorTranslation(langCode, translation));
        }
        repository.save(author);
        return mapper.toDTO(author.getNameTranslations());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void clearAuthorNameTranslationsList(String name) {
        Author author = repository.getByName(name);
        author.getNameTranslations().clear();
        repository.save(author);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        Author author = repository.getByName(name);
        author.getNameTranslations()
              .remove(repository.getTranslationFor(author, langCode));
        repository.save(author);
    }

    @Override
    public String getAuthorNameTranslationByLangCode(String name,
                                                     String langCode) {
        return repository.getByName(name)
                         .getNameTranslations()
                         .stream()
                         .filter(byLanguageCode(langCode))
                         .map(AuthorTranslation::getName)
                         .findAny()
                         .orElseThrow(() -> new EntityNotFoundException(
                                 "'" + langCode + "' name translation for "
                                 + "author " + "named " + name
                                 + " was not found!"));
    }

    private Predicate<AuthorTranslation> byLanguageCode(String langCode) {
        return translation -> Objects.equals(
                translation.getLanguage().getCode(), langCode);
    }
}
