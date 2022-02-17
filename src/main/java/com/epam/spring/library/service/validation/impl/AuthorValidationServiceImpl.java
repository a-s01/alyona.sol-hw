package com.epam.spring.library.service.validation.impl;

import com.epam.spring.library.exception.InvalidStateException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.validation.AuthorValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthorValidationServiceImpl implements AuthorValidationService {
    private final BookRepository bookRepository;

    @Override
    public void validateDelete(Author author) {
        if (!bookRepository.findByAuthorsContaining(author).isEmpty()) {
            throw new InvalidStateException("There are books with such author "
                                            + "listed, cannot delete it");
        }
    }
}
