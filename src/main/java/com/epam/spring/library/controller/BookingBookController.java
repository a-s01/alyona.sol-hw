package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookingBookAPI;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingBookController implements BookingBookAPI {
    private final BookingService service;

    @Override
    public List<BookDTO> getBooksInBooking(int id) {
        return service.getBooksInBooking(id);
    }

    @Override
    public List<BookDTO> addBookListToBooking(int id,
                                              @RequestBody
                                                      List<BookDTO> bookDTOs) {
        return service.addBookToBooking(id, bookDTOs);
    }

    @Override
    public List<BookDTO> updateBooksListInBooking(int id,
                                                  @RequestBody
                                                          List<BookDTO> bookDTOs) {
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
