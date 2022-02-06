package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@ToString(exclude = {"password", "confirmPassword"})
@JsonInclude(NON_ABSENT)
public class UserDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @Email(groups = {OnUpdate.class, OnCreate.class})
    @NotBlank(message = "User email must be not blank", groups = OnCreate.class)
    @Pattern(regexp = "\\S", message = "User email must be not blank",
             groups = OnUpdate.class)
    private String email;

    @NotBlank(message = "User password must be not blank",
              groups = OnCreate.class)
    @Null(message = "Use special method for updating password",
          groups = OnUpdate.class)
    private String password;

    @NotBlank(message = "Confirm password must be not blank",
              groups = OnCreate.class)
    @Null(message = "Use special method for updating password",
          groups = OnUpdate.class)
    private String confirmPassword;
    private String role;
    private String state;
    private @Null(groups = {OnUpdate.class, OnCreate.class}) Double fine;
    private String name;

    @NotBlank(message = "User preferred language must be not blank",
              groups = OnCreate.class)
    @Pattern(regexp = "\\S", message = "User preferred language must be not blank",
             groups = OnUpdate.class)
    private String preferredLanguage;

    /**
     * For avoiding password and salt leak through Builder toString() method,
     * we should override it
     */
    public static class UserDTOBuilder {
        @Override
        public String toString() {
            return "UserDTOBuilder(***)";
        }
    }
}
