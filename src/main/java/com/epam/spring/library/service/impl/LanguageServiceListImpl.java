package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.repository.LanguageRepository;
import com.epam.spring.library.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceListImpl implements LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public List<String> getSupportedLanguages() {
        return mapper.toDTO(repository.getSupportedLanguages());
    }
}
