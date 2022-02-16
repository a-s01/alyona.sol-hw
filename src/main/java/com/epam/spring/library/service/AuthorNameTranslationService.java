package com.epam.spring.library.service;

import java.util.Map;

public interface AuthorNameTranslationService {

    Map<String, String> getAllAuthorNameTranslations(String name);

    Map<String, String> updateAuthorNameTranslation(String name,
                                                    String langCode,
                                                    String nameTranslation);

    void clearAuthorNameTranslationsList(String name);

    void deleteAuthorNameTranslationByLangCode(String name, String langCode);

    String getAuthorNameTranslationByLangCode(String name, String langCode);
}
