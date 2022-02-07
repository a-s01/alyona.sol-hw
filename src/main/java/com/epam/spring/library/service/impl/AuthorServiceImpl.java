package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;
    private final LanguageMapper languageMapper;

    @Override
    public AuthorDTO getAuthor(String name) {
        return mapper.toDTO(repository.getAuthor(name));
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author newAuthor = mapper.toAuthor(authorDTO);
        return mapper.toDTO(repository.createAuthor(newAuthor));
    }

    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        Author toUpdate = repository.getAuthor(name);
        mapper.updateAuthor(authorDTO, toUpdate);
        return mapper.toDTO(repository.updateAuthor(toUpdate));
    }

    @Override
    public void deleteAuthor(String name) {
        repository.deleteAuthor(name);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return mapper.toDTO(repository.getAllAuthors());
    }

    @Override
    public Map<String, String> getAllAuthorNameTranslations(String name) {
        Author author = repository.getAuthor(name);
        return languageMapper.toDTO(author.getNameTranslations());
    }

    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String nameTranslation) {

        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getNameTranslations().put(lang, nameTranslation);
        return languageMapper.toDTO(author.getNameTranslations());
    }

    @Override
    public void clearAuthorNameTranslationsList(String name) {
        repository.getAuthor(name).getNameTranslations().clear();
    }

    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getNameTranslations().remove(lang);
    }

    @Override
    public String getAuthorNameTranslationByLangCode(String name,
                                                     String langCode) {
        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);

        if (!author.getNameTranslations().containsKey(lang)) {
            throw new EntityNotFoundException("Author named " + name + " name translation "
                                              + "in " + langCode + " not found!");
        }
        return author.getNameTranslations().get(lang);
    }
}
