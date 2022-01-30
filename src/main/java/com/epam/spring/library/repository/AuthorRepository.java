package com.epam.spring.library.repository;

import com.epam.spring.library.model.Author;

import java.util.List;

public interface AuthorRepository {

    Author getAuthor(String name);

    Author createAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthor(String name);

    List<Author> getAllAuthors();
}
