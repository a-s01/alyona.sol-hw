package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.model.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.Year;
import java.util.List;

@Mapper(componentModel = "spring", uses = AuthorMapper.class)
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toBook(BookDTO bookDto);

    List<BookDTO> toDTO(List<Book> books);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    void updateBook(BookDTO bookDTO, @MappingTarget Book book);

    default int map(Year year) {
        return year.getValue();
    }

    default Year map(int year) {
        return Year.of(year);
    }
}
