package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = LanguageMapper.class)
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "confirmPassword", ignore = true)
    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

    User toUser(UserDTO userDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateUser(UserDTO userDTO, @MappingTarget User user);
}
