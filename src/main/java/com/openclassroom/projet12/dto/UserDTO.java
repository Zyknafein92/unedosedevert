package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.Role;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDTO {

    private Long id;

    private List<AdressDTO> adresses;

    private ShoppingCartDTO shoppingCart;

    private List<OrderDTO> orders;

    private Set<Role> roles;

    @NotNull(message= "Veuillez renseigner votre sexe !")
    private String gender;

    @NotNull(message= "Veuillez renseigner votre nom !")
    private String lastName;

    @NotNull(message= "Veuillez renseigner votre prénom !")
    private String firstName;

    @NotNull(message= "Veuillez renseigner une date de naissance !")
    private LocalDate birthday;

    @NotNull(message= "Veuillez renseigner un email !")
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

    private String forgotPasswordToken;

    private LocalDateTime forgotPasswordTokenExpiration;

    private Boolean active;

    private Boolean newsletter;
}
