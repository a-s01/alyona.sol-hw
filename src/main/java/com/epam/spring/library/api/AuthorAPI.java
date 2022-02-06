package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Validated
@RequestMapping("api/v1/author")
public interface AuthorAPI {

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO getAuthor(@PathVariable @NotBlank String name);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AuthorDTO> getAllAuthors();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO createAuthor(@RequestBody @Valid AuthorDTO authorDTO);

    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO updateAuthor(@PathVariable @NotBlank String name,
                           @RequestBody @Valid AuthorDTO authorDTO);

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthor(@PathVariable @NotBlank String name);

    @GetMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> getAllAuthorNameTranslations(@PathVariable @NotBlank String name);

    @GetMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    String getAuthorNameTranslationByLangCode(@PathVariable @NotBlank String name,
                                              @PathVariable @NotBlank String langCode);

    @PutMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> updateAuthorNameTranslation(@PathVariable @NotBlank String name,
                                                    @PathVariable @NotBlank
                                                            String langCode,
                                                    @RequestBody @NotBlank
                                                            String nameTranslation);

    @DeleteMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorNameTranslationsList(@PathVariable @NotBlank String name);

    @DeleteMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorNameTranslationByLangCode(@PathVariable @NotBlank String name,
                                               @PathVariable @NotBlank String langCode);
}
