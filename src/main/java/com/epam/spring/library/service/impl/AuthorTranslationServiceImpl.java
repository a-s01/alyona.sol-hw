package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.AuthorTranslationMapper;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.AuthorTranslation;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
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

    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String nameTranslation) {
        Author author = repository.getByName(name);
        author.getNameTranslations()
              .add(mapper.toAuthorTranslation(langCode, nameTranslation));
        repository.save(author);
        return mapper.toDTO(author.getNameTranslations());
    }

    @Override
    public void clearAuthorNameTranslationsList(String name) {
        Author author = repository.getByName(name);
        author.getNameTranslations().clear();
        repository.save(author);
    }

    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        Author author = repository.getByName(name);
        author.getNameTranslations().removeIf(byLanguageCode(langCode));
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
                                 "Author named " + name
                                 + " name translation in " + langCode
                                 + " not found!"));
    }

    private Predicate<AuthorTranslation> byLanguageCode(String langCode) {
        return translation -> Objects.equals(
                translation.getLanguage().getCode(), langCode);
    }
}
