package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingDTO {
    private UserDTO user;
    private String state;
    private String located;
    private List<BookDTO> books;
}
