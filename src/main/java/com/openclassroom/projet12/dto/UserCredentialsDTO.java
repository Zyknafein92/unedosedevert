package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
public class UserCredentialsDTO {

    @NotNull(message= "Veuillez renseigner un email !")
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

    private Set<Role> roles;
}
