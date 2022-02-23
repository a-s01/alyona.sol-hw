package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.exception.EntityAlreadyExistsException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorService;
import com.epam.spring.library.service.validation.AuthorValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorValidationService validator;
    private final AuthorMapper mapper;

    @Override
    public AuthorDTO getAuthor(String name) {
        return mapper.toDTO(repository.getByName(name));
    }

    /**
     * I'm struggling to figure out why hibernate generated id sequence
     * isn't subject for rollback upon save. The SimpleJpaRepository save(..)
     * method is @Transactional, the id is updated inside it... why doesn't it
     * perform a rollback in case of constraint violation, for example? If you
     * could possibly explain, I will appreciate it a lot.
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        if (repository.existsByName(authorDTO.getName())) {
            throw new EntityAlreadyExistsException(
                    "Author with name " + authorDTO.getName()
                    + " already exists.");
        }
        Author newAuthor = mapper.toAuthor(authorDTO);
        return mapper.toDTO(repository.save(newAuthor));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        Author toUpdate = repository.getByName(name);
        mapper.updateAuthor(authorDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void deleteAuthor(String name) {
        Optional<Author> author = repository.findByName(name);
        if (author.isPresent()) {
            validator.validateDelete(author.get());
            repository.delete(author.get());
        }
    }

    @Override
    public Page<AuthorDTO> getAllAuthors(Pageable page) {
        return repository.findAll(page).map(mapper::toDTO);
    }
}
