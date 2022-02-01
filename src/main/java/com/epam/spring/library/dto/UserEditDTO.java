package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

/**
 * Will be replaced by validation on OnEdit.class in next iteration of homework
 */
@Data
@Builder
@ToString(exclude = {"password", "confirmPassword"})
public class UserEditDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String state;
    private String name;
    private String preferredLanguage;

    /**
     * For avoiding password and salt leak through Builder toString() method,
     * we should override it
     */
    public static class UserEditDTOBuilder {
        @Override
        public String toString() {
            return "UserEditDTOBuilder(***)";
        }
    }
}
