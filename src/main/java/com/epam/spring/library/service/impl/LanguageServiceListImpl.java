package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.repository.LanguageRepository;
import com.epam.spring.library.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LanguageServiceListImpl implements LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public Page<String> getSupportedLanguages(Pageable page) {
        return repository.findAll(page).map(mapper::toDTO);
    }
}
