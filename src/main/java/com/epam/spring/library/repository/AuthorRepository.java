package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>, AuthorTranslationRepository {

    Optional<Author> findByName(String name);

    default Author getByName(String name) {
        return findByName(name).orElseThrow(() -> new EntityNotFoundException(
                "Author named " + name + " was not found"));
    }
}
