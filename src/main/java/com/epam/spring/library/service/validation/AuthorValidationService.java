package com.epam.spring.library.service.validation;

import com.epam.spring.library.model.Author;

public interface AuthorValidationService {

    void validateDelete(Author author);
}
