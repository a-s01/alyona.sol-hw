package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;
import com.epam.spring.library.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = LanguageMapper.class)
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

    User userDTOtoUser(UserDTO userDto);

    User createUser(UserEditDTO userEditDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateUser(UserEditDTO userEditDTO, @MappingTarget User user);
}
