package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.model.Author;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryListImpl implements AuthorRepository {
    private final BaseRepository<Author> repository;

    @Override
    public Author getAuthor(String name) {
        return repository.get(name, Author::getDefaultName);
    }

    @Override
    public Author createAuthor(Author author) {
        return repository.create(author, Author::getDefaultName);
    }

    @Override
    public Author updateAuthor(Author author) {
        return repository.update(author, Author::getDefaultName);
    }

    @Override
    public void deleteAuthor(String name) {
        repository.delete(name, Author::getDefaultName);
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.getAll();
    }
}
