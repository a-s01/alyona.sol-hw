package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookDTO;

import java.util.Set;

public interface BookingBookService {

    Set<BookDTO> addBookToBooking(int id, Set<BookDTO> bookDTOs);

    void deleteBookFromBooking(int id, String isbn);

    Set<BookDTO> getBooksInBooking(int id);

    Set<BookDTO> updateBooksListInBooking(int id, Set<BookDTO> bookDTOs);

    void clearBookListInBooking(int id);
}
