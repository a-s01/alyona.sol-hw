package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorNameTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
class AuthorNameTranslationServiceImpl implements AuthorNameTranslationService {
    private final AuthorRepository repository;
    private final LanguageMapper languageMapper;

    @Override
    public Map<String, String> getAllAuthorNameTranslations(String name) {
        Author author = repository.getByName(name);
        return languageMapper.toDTO(author.getNameTranslations());
    }

    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String nameTranslation) {

        Author author = repository.getByName(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getNameTranslations().put(lang, nameTranslation);
        return languageMapper.toDTO(author.getNameTranslations());
    }

    @Override
    public void clearAuthorNameTranslationsList(String name) {
        repository.getByName(name).getNameTranslations().clear();
    }

    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        Author author = repository.getByName(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getNameTranslations().remove(lang);
    }

    @Override
    public String getAuthorNameTranslationByLangCode(String name,
                                                     String langCode) {
        Author author = repository.getByName(name);
        Language lang = languageMapper.toLanguage(langCode);

        if (!author.getNameTranslations().containsKey(lang)) {
            throw new EntityNotFoundException("Author named " + name + " name translation "
                                              + "in " + langCode + " not found!");
        }
        return author.getNameTranslations().get(lang);
    }
}
