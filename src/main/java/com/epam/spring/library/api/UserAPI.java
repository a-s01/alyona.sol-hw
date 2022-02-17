package com.epam.spring.library.api;

import com.epam.spring.library.dto.ErrorDTO;
import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "User API")
@ApiResponses(
        value = {@ApiResponse(responseCode = "200", description = "User found",
                              content = {@Content(
                                      mediaType = APPLICATION_JSON_VALUE,
                                      array = @ArraySchema(schema = @Schema(
                                              implementation = UserDTO.class)))}),
                 @ApiResponse(responseCode = "400",
                              description = "Invalid request",
                              content = {@Content(
                                      mediaType = APPLICATION_JSON_VALUE,
                                      array = @ArraySchema(schema = @Schema(
                                              implementation = ErrorDTO.class)))}),
                 @ApiResponse(responseCode = "404",
                              description = "User not found",
                              content = {@Content(
                                      mediaType = APPLICATION_JSON_VALUE,
                                      array = @ArraySchema(schema = @Schema(
                                              implementation = ErrorDTO.class)))}),
                 @ApiResponse(responseCode = "409",
                              description = "Unacceptable operation due"
                                            + " to current user state",
                              content = {@Content(
                                      mediaType = APPLICATION_JSON_VALUE,
                                      array = @ArraySchema(schema = @Schema(
                                              implementation = ErrorDTO.class)))})})
@Validated
@RequestMapping("api/v1/user")
public interface UserAPI {

    @Operation(summary = "Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    UserDTO getUser(@PathVariable @NotBlank String email);

    @Operation(summary = "Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<UserDTO> getAllUsers(Pageable page);

    @Operation(summary = "Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO);

    @Operation(summary = "Update user")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{email}")
    UserDTO updateUser(@PathVariable @NotBlank
                       @Parameter(description = "to be updated user's email")
                               String email,
                       @RequestBody @Validated(OnUpdate.class) UserDTO userDTO);

    @Operation(summary = "Delete user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteUser(@PathVariable @NotBlank String email);
}
