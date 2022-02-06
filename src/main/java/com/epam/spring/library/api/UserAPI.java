package com.epam.spring.library.api;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
public interface UserAPI {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    UserDTO getUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserDTO> getAllUsers();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDTO createUser(@RequestBody UserEditDTO userEditDTO);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{email}")
    UserDTO updateUser(@PathVariable String email,
                       @RequestBody UserEditDTO userEditDTO);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteUser(@PathVariable String email);
}
