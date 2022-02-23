package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookingBookAPI;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookingBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookingBookController implements BookingBookAPI {
    private final BookingBookService service;

    @Override
    public Set<BookDTO> getBooksInBooking(int id) {
        return service.getBooksInBooking(id);
    }

    @Override
    public Set<BookDTO> addBookListToBooking(int id,
                                             @RequestBody
                                             @NotEmpty Set<@Valid BookDTO> bookDTOs) {
        return service.addBookToBooking(id, bookDTOs);
    }

    @Override
    public Set<BookDTO> updateBooksListInBooking(int id,
                                                 @RequestBody
                                                 @NotEmpty Set<@Valid BookDTO> bookDTOs) {
        return service.updateBooksListInBooking(id, bookDTOs);
    }

    @Override
    public void deleteBookFromBooking(int id, String isbn) {
        service.deleteBookFromBooking(id, isbn);
    }

    @Override
    public void clearBookListInBooking(int id) {
        service.clearBookListInBooking(id);
    }
}
