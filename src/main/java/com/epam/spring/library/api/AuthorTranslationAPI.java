package com.epam.spring.library.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Tag(name = "Author name translations API")
@Validated
@RequestMapping("api/v1/author")
public interface AuthorTranslationAPI {

    @Operation(summary = "Get all author name translations")
    @GetMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> getAllAuthorNameTranslations(
            @PathVariable @NotBlank String name);

    @Operation(
            summary = "Get all author name translation in given ISO language "
                      + "code")
    @GetMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    String getAuthorNameTranslationByLangCode(
            @PathVariable @NotBlank String name,
            @Parameter(description = "ISO 2- or 3-letters language code")
            @PathVariable @NotBlank String langCode);

    @Operation(
            summary = "Update author name translation in given ISO language "
                      + "code")
    @PutMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.OK)
    Map<String, String> updateAuthorNameTranslation(
            @PathVariable @NotBlank String name,
            @PathVariable @NotBlank String langCode,
            @RequestBody @NotBlank String nameTranslation);

    @Operation(summary = "Delete all author name translations")
    @DeleteMapping("/{name}/name-translations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorNameTranslationsList(@PathVariable @NotBlank String name);

    @Operation(
            summary = "Delete author name translation in given ISO language "
                      + "code")
    @DeleteMapping("/{name}/name-translations/{langCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorNameTranslationByLangCode(
            @PathVariable @NotBlank String name,
            @PathVariable @NotBlank String langCode);
}
