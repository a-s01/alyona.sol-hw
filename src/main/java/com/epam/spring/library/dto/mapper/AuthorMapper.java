package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.model.Author;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = LanguageMapper.class)
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    Author toAuthor(AuthorDTO authorDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "i18Names",
             defaultExpression = "java(new java.util.HashMap())")
    void updateAuthor(AuthorDTO authorDTO, @MappingTarget Author author);
}
