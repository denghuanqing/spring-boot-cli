package com.poppy.admin.security;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 */
@Getter
@Setter
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Override
    public String toString() {
        return "{username=" + username  + ", password= ******}";
    }
}
