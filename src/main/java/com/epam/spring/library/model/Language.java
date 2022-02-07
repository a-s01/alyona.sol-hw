package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Language implements Entity {
    private int id;
    private String code;
}
