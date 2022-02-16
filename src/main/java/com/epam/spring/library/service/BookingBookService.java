package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookDTO;

import java.util.List;

public interface BookingBookService {

    List<BookDTO> addBookToBooking(int id, List<BookDTO> bookDTOs);

    void deleteBookFromBooking(int id, String isbn);

    List<BookDTO> getBooksInBooking(int id);

    List<BookDTO> updateBooksListInBooking(int id, List<BookDTO> bookDTOs);

    void clearBookListInBooking(int id);
}
