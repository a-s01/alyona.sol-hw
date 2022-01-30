package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.repository.LanguageRepository;
import com.epam.spring.library.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LanguageServiceListImpl implements LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public List<String> getSupportedLanguages() {
        log.info("get all supported languages");
        return mapper.toDTO(repository.getSupportedLanguages());
    }
}
