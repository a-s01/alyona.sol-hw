package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorDTO getAuthor(String name) {
        return mapper.toDTO(repository.getByName(name));
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author newAuthor = mapper.toAuthor(authorDTO);
        return mapper.toDTO(repository.save(newAuthor));
    }

    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        Author toUpdate = repository.getByName(name);
        mapper.updateAuthor(authorDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }

    @Override
    public void deleteAuthor(String name) {
        repository.deleteByName(name);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return mapper.toDTO(repository.findAll());
    }
}
