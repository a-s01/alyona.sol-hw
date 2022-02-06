package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/author")
public interface AuthorAPI {

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO getAuthor(@PathVariable String name);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AuthorDTO> getAllAuthors();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO);

    @PatchMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO updateAuthor(@PathVariable String name,
                           @RequestBody AuthorDTO authorDTO);

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthor(@PathVariable String name);

    @GetMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> getAllAuthorNameTranslations(@PathVariable String name);

    @GetMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    String getAuthorNameTranslationByLangCode(@PathVariable String name,
                                              @PathVariable String langCode);

    @PutMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> updateAuthorNameTranslation(@PathVariable String name,
                                                    @PathVariable
                                                            String langCode,
                                                    @RequestBody
                                                            String nameTranslation);

    @DeleteMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorNameTranslationsList(@PathVariable String name);

    @DeleteMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorNameTranslationByLangCode(@PathVariable String name,
                                               @PathVariable String langCode);
}
