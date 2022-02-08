package com.epam.spring.library.dto;

import com.epam.spring.library.exception.ErrorType;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ErrorDTO {
    private final String message;
    private final ErrorType errorType;
    private final Instant timestamp;
}
