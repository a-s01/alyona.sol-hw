package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.epam.spring.library.model.User;
import com.epam.spring.library.validation.constraint.EnumValue;
import com.epam.spring.library.validation.constraint.FieldsValueMatch;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Schema(title = "User schema", description = "User info")
@Data
@Builder
@ToString(exclude = {"password", "confirmPassword"})
@JsonInclude(NON_ABSENT)
@FieldsValueMatch(field = "password", otherField = "confirmPassword",
                  groups = OnCreate.class)
public class UserDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @Email(groups = {OnUpdate.class, OnCreate.class})
    @NotBlank(message = "{user.email.empty}", groups = OnCreate.class)
    // On update, I want to be able to not specifying email, but if I do specify
    // it, it must be not blank. @NotBlank doesn't allow the first part,
    // so I use this pattern here
    @Pattern(regexp = "\\S", message = "{user.email.empty}",
             groups = OnUpdate.class)
    private String email;

    @Schema(description = "User password. Must be the same as confirmPassword")
    @NotBlank(message = "{user.password.empty}", groups = OnCreate.class)
    @Null(message = "{user.password.update.forbidden}", groups = OnUpdate.class)
    private String password;

    @Schema(description = "User confirmed password. Must be the same as "
                          + "password")
    @NotBlank(message = "{user.password.confirm.empty}",
              groups = OnCreate.class)
    @Null(message = "{user.password.update.forbidden}", groups = OnUpdate.class)
    private String confirmPassword;

    @Schema(allowableValues = {"USER", "LIBRARIAN", "ADMIN"})
    @EnumValue(of = User.Role.class, groups = {OnCreate.class, OnUpdate.class})
    private String role;

    @Schema(allowableValues = {"VALID", "BLOCKED"})
    @EnumValue(of = User.State.class, groups = {OnCreate.class, OnUpdate.class})
    private String state;

    @Null(groups = {OnUpdate.class, OnCreate.class})
    @JsonProperty(access = READ_ONLY)
    private Double fine;

    private String name;

    @Schema(description = "ISO-639 language code", example = "uk",
            externalDocs = @ExternalDocumentation(
                    url = "https://www.loc.gov/standards/iso639-2/php"
                          + "/English_list.php"))
    @Pattern(regexp = "\\S", message = "{user.language.empty}",
             groups = OnUpdate.class)
    private String preferredLanguage;

    /**
     * For avoiding password and salt leak through Builder toString()
     * method,
     * we should override it
     */
    public static class UserDTOBuilder {
        @Override
        public String toString() {
            return "UserDTOBuilder(***)";
        }
    }
}
