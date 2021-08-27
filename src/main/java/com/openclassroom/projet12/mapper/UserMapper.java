package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.model.Adress;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.ShoppingCartLine;
import com.openclassroom.projet12.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public static User createUser(UserDTO userDTO) {

        return User.builder()
                .id(userDTO.getId())
                .adresses(new ArrayList<>())
                .gender(userDTO.getGender())
                .lastName(userDTO.getLastName())
                .firstName(userDTO.getFirstName())
                .birthday(userDTO.getBirthday())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .newsletter(false)
                .shoppingCart(new ShoppingCart())
                .build();
    }

    public static User toUser(UserDTO userDTO) {

        List<Adress> adressList = userDTO.getAdresses().stream().map(AdressMapper::toAdresse).collect(Collectors.toList());
        List<ShoppingCartLine> shoppingCartLineList = userDTO.getShoppingCart().getShoppingCartLines().stream().map(ShoppingCartLineMapper::toShoppingCartLine).collect(Collectors.toList());

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(userDTO.getShoppingCart().getId())
                .shoppingCartLines(shoppingCartLineList)
                .build();

        return User.builder()
                .id(userDTO.getId())
                .adresses(adressList)
                .gender(userDTO.getGender())
                .lastName(userDTO.getLastName())
                .firstName(userDTO.getFirstName())
                .birthday(userDTO.getBirthday())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .shoppingCart(shoppingCart)
                .forgotPasswordToken(userDTO.getForgotPasswordToken())
                .forgotPasswordTokenExpiration(userDTO.getForgotPasswordTokenExpiration())
                .newsletter(userDTO.getNewsletter())
                .build();
    }

    public static UserDTO toUserDTO(User user) {
        List<AdressDTO> adressDTOList = user.getAdresses().stream().map(AdressMapper::toAdresseDTO).collect(Collectors.toList());
        List<ShoppingCartLineDTO> panierLigneList = user.getShoppingCart().getShoppingCartLines().stream().map(ShoppingCartLineMapper::toShoppingCartLineDTO).collect(Collectors.toList());
        List<OrderDTO> orderDTOList = user.getOrders().stream().map(OrderMapper::toOrderDTO).collect(Collectors.toList());
        ShoppingCartDTO shoppingCartDTO = ShoppingCartDTO.builder()
                .id(user.getShoppingCart().getId())
                .shoppingCartLines(panierLigneList)
                .build();

        return UserDTO.builder()
                .id(user.getId())
                .adresses(adressDTOList)
                .gender(user.getGender())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .birthday(user.getBirthday())
                .email(user.getEmail())
                .orders(orderDTOList)
                .password(user.getPassword())
                .shoppingCart(shoppingCartDTO)
                .forgotPasswordToken(user.getForgotPasswordToken())
                .forgotPasswordTokenExpiration(user.getForgotPasswordTokenExpiration())
                .newsletter(user.getNewsletter())
                .build();
    }

    public static UserDTO toUserDTOOrder(User user) {
        List<OrderDTO> orderDTOList = user.getOrders().stream().map(OrderMapper::toOrderDTO).collect(Collectors.toList());
        return UserDTO.builder()
                .orders(orderDTOList)
                .build();
    }

    public static void update(UserDTO dto, User entity) {
        entity.setGender(dto.getGender());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setBirthday(dto.getBirthday());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setNewsletter(dto.getNewsletter());
        entity.setForgotPasswordToken(dto.getForgotPasswordToken());
        entity.setForgotPasswordTokenExpiration(dto.getForgotPasswordTokenExpiration());
    }
}


