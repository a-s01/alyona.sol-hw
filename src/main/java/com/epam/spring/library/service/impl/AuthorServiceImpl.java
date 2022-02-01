package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;
    private final LanguageMapper languageMapper;

    @Override
    public AuthorDTO getAuthor(String name) {
        log.info("get author by name {}", name);
        return mapper.toDTO(repository.getAuthor(name));
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        log.info("create author from {}", authorDTO);
        Author newAuthor = mapper.toAuthor(authorDTO);
        return mapper.toDTO(repository.createAuthor(newAuthor));
    }

    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        log.info("update author named {} with new info {}", name,
                 authorDTO);
        Author toUpdate = repository.getAuthor(name);
        mapper.updateAuthor(authorDTO, toUpdate);
        return mapper.toDTO(repository.updateAuthor(toUpdate));
    }

    @Override
    public void deleteAuthor(String name) {
        log.info("delete author {}", name);
        repository.deleteAuthor(name);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        log.info("get all authors");
        return mapper.toDTO(repository.getAllAuthors());
    }

    @Override
    public Map<String, String> getAuthorI18Names(String name) {
        log.info("get author named {} all name translations", name);
        Author author = repository.getAuthor(name);
        log.info("success: get author named {} all name translations", name);
        return languageMapper.toDTO(author.getI18Names());
    }

    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String nameTranslation) {
        log.info("update author named {} {} translation with {}", name,
                 langCode, nameTranslation
                );
        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getI18Names().put(lang, nameTranslation);
        log.info("success: author named {} {} translation update", name,
                 langCode);
        return languageMapper.toDTO(author.getI18Names());
    }

    @Override
    public void clearAuthorI18Names(String name) {
        log.info("clear author named {} all name translations", name);
        Author author = repository.getAuthor(name);
        author.getI18Names().clear();
        log.info("success: clear author named {} all name translations", name);
    }

    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        log.info("delete author named {} {} translation", name, langCode);
        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);
        author.getI18Names().remove(lang);
        log.info("success: delete author named {} {} translation", name,
                 langCode);
    }

    @Override
    public String getAuthorNameTranslationByLangCode(String name,
                                                     String langCode) {
        log.info("get author named {} name translation in {}", name, langCode);
        Author author = repository.getAuthor(name);
        Language lang = languageMapper.toLanguage(langCode);

        if (!author.getI18Names().containsKey(lang)) {
            throw new RuntimeException("Author named " + name + " name translation "
                                       + "in " + langCode + " not found!");
        }
        return author.getI18Names().get(lang);
    }
}
