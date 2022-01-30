package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorDTO getAuthor(String name) {
        log.info("get author by name {}", name);
        return mapper.toDTO(repository.getAuthor(name));
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        log.info("create author from {}", authorDTO);
        Author newAuthor = mapper.toAuthor(authorDTO);
        return mapper.toDTO(repository.createAuthor(newAuthor));
    }

    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        Author toUpdate = repository.getAuthor(name);
        log.info("update author {} with new info {}", toUpdate, authorDTO);
        mapper.updateAuthor(authorDTO, toUpdate);
        return mapper.toDTO(repository.updateAuthor(toUpdate));
    }

    @Override
    public void deleteAuthor(String name) {
        log.info("delete author {}", name);
        repository.deleteAuthor(name);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        log.info("get all authors");
        return mapper.toDTO(repository.getAllAuthors());
    }
}
