package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.epam.spring.library.validation.FieldsValueMatch;
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
@FieldsValueMatch(
        field = "password",
        otherField = "confirmPassword",
        groups = OnCreate.class
        //message = "{passwords.does.not.match}"
)
public class UserDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @Email(groups = {OnUpdate.class, OnCreate.class})
    @NotBlank(message = "{user.email.empty}", groups = OnCreate.class)
    @Pattern(regexp = "\\S", message = "{user.email.empty}",
             groups = OnUpdate.class)
    private String email;

    @NotBlank(message = "{user.password.empty}",
              groups = OnCreate.class)
    @Null(message = "{user.password.update.forbidden}",
          groups = OnUpdate.class)
    private String password;

    @NotBlank(message = "{user.password.confirm.empty}",
              groups = OnCreate.class)
    @Null(message = "{user.password.update.forbidden}",
          groups = OnUpdate.class)
    private String confirmPassword;
    private String role;
    private String state;
    private @Null(groups = {OnUpdate.class, OnCreate.class}) Double fine;
    private String name;

    @NotBlank(message = "{user.language.empty}",
              groups = OnCreate.class)
    @Pattern(regexp = "\\S", message = "{user.language.empty}",
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
