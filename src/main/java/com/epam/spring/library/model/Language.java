package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Language {
    private int id;
    private String code;
}
