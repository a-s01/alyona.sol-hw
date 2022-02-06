package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.model.Author;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = LanguageMapper.class)
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    Set<AuthorDTO> toDTO(Set<Author> authors);

    List<AuthorDTO> toDTO(List<Author> authors);

    Author toAuthor(AuthorDTO authorDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateAuthor(AuthorDTO authorDTO, @MappingTarget Author author);
}
