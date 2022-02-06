package com.epam.spring.library.api;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RequestMapping("api/v1/user")
public interface UserAPI {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    UserDTO getUser(@PathVariable @NotBlank String email);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserDTO> getAllUsers();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{email}")
    UserDTO updateUser(@PathVariable @NotBlank String email,
                       @RequestBody @Validated(OnUpdate.class) UserDTO userDTO);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteUser(@PathVariable @NotBlank String email);
}
