package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.model.Book;
import org.mapstruct.*;

import java.time.Year;
import java.util.Set;

@Mapper(componentModel = "spring", uses = AuthorMapper.class)
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toBook(BookDTO bookDto);

    Set<BookDTO> toDTO(Set<Book> books);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateBook(BookDTO bookDTO, @MappingTarget Book book);

    default int map(Year year) {
        return year.getValue();
    }

    default Year map(int year) {
        return Year.of(year);
    }
}
