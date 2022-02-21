package com.epam.spring.library.dto;

import com.epam.spring.library.exception.ErrorType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Schema(title = "Error schema")
@Data
@Builder
public class ErrorDTO {
    private final String message;
    private final ErrorType errorType;
    private final Instant timestamp;
}
