package com.epam.spring.library.controller;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO getAuthor(@PathVariable String name) {
        return service.getAuthor(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.createAuthor(authorDTO);
    }

    @PatchMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO updateAuthor(@PathVariable String name,
                                  @RequestBody AuthorDTO authorDTO) {
        return service.updateAuthor(name, authorDTO);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable String name) {
        service.deleteAuthor(name);
    }

    @GetMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getAllAuthorNameTranslations(
            @PathVariable String name) {
        return service.getAllAuthorNameTranslations(name);
    }

    @GetMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    public String getAuthorNameTranslationByLangCode(@PathVariable String name,
                                                     @PathVariable
                                                             String langCode) {
        return service.getAuthorNameTranslationByLangCode(name, langCode);
    }

    @PutMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> updateAuthorNameTranslation(
            @PathVariable String name,
            @PathVariable String langCode,
            @RequestBody String nameTranslation) {
        return service.updateAuthorNameTranslation(name, langCode,
                                                   nameTranslation);
    }

    @DeleteMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearAuthorNameTranslationsList(@PathVariable String name) {
        service.clearAuthorNameTranslationsList(name);
    }

    @DeleteMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorNameTranslationByLangCode(@PathVariable String name,
                                                      @PathVariable
                                                              String langCode) {
        service.deleteAuthorNameTranslationByLangCode(name, langCode);
    }
}
