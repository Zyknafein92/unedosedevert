package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.ShoppingCartLine;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.ShoppingCartLineRepository;
import com.openclassroom.projet12.respository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartLineRepository shoppingCartLineRepository;
    private final UserService userService;
    private final VariantService variantService;


    public ShoppingCartDTO getShoppingCart(String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            List<ShoppingCartLineDTO> shoppingCartLineDTOList = userDTO.getShoppingCart().getShoppingCartLines();
            if (userDTO.getShoppingCart().getShoppingCartLines().size() > 0)
                userDTO.getShoppingCart().setTotalPrice(shoppingCartLineDTOList.stream().mapToDouble(ShoppingCartLineDTO::getPrice).reduce(Double::sum).getAsDouble());
            return userDTO.getShoppingCart();
        } else throw new NotFoundException("Le shoppingCart n'existe pas !");
    }

    public ShoppingCart addToShoppingCart(List<ShoppingCartLineDTO> shoppingCartLineDTOList, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            for (ShoppingCartLineDTO shoppingCartLineDTO : shoppingCartLineDTOList) {
                userDTO.getShoppingCart().getShoppingCartLines().add(shoppingCartLineDTO);
            }
            ShoppingCart shoppingCart = ShoppingCartMapper.toShoppingCart(userDTO.getShoppingCart());
            return shoppingCartRepository.save(shoppingCart);
        } else throw new RuntimeException("Une erreur s'est produite");
    }

    public ShoppingCart renewOrder(OrderDTO orderDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        List<VariantOrderDTO> listToRenew = orderDTO.getVariantOrderDTOS();
        for (VariantOrderDTO vod : listToRenew) {
            VariantDTO variantDTO = variantService.getVariantDTO(vod.getVariantID());

            ShoppingCartLineDTO shoppingCartLineDTO = ShoppingCartLineDTO.builder()
                    .variant(variantDTO)
                    .product(vod.getProductDTO())
                    .price(variantDTO.getPrice())
                    .quantity(vod.getQuantity())
                    .build();

            userDTO.getShoppingCart().getShoppingCartLines().add(shoppingCartLineDTO);
        }
        User user = UserMapper.toUser(userDTO);
        userDTO.getShoppingCart().setTotalPrice(userDTO.getShoppingCart().getShoppingCartLines().stream().mapToDouble(ShoppingCartLineDTO::getPrice).reduce(Double::sum).getAsDouble());
        userService.save(user);
        return user.getShoppingCart();
    }


    // ShoppingCartLine //

    public ShoppingCartLine getShoppingCartLine(Long id) {
        return shoppingCartLineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La ligne du shoppingCart n'existe pas !"));
    }

    public ShoppingCartLine addShoppingCartLine(ShoppingCartLineDTO shoppingCartLineDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        ShoppingCartLine entityToReturn = null;
        ShoppingCartLineDTO existingData = null;
        boolean existingValue = false;
        if (userDTO != null) {
            for (ShoppingCartLineDTO s : userDTO.getShoppingCart().getShoppingCartLines()) {
                if (isContainInShoppingCart(s.getVariant().getId(), shoppingCartLineDTO.getVariant().getId())) {
                    existingValue = true;
                    existingData = s;
                    break;
                }
            }
            if (existingValue) {
                existingData.setQuantity(existingData.getQuantity() + shoppingCartLineDTO.getQuantity());
                existingData.setPrice(existingData.getVariant().getPrice() * existingData.getQuantity());
                entityToReturn = ShoppingCartLineMapper.toShoppingCartLine(existingData);
                shoppingCartLineRepository.save(entityToReturn);
            } else {
                entityToReturn = ShoppingCartLineMapper.toShoppingCartLine(shoppingCartLineDTO);
                userDTO.getShoppingCart().getShoppingCartLines().add(shoppingCartLineDTO);
                User entityToSave = UserMapper.toUser(userDTO);
                userService.save(entityToSave);

            }
            return entityToReturn;
        } else throw new NotFoundException("Une erreure s'est produite");
    }

    public ShoppingCartLine updateShoppingCartLine(ShoppingCartLineDTO shoppingCartLineDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        ShoppingCartLine shoppingCartLine = getShoppingCartLine(shoppingCartLineDTO.getId());
        if (userDTO != null && shoppingCartLine != null) {
            ShoppingCartLineMapper.update(shoppingCartLineDTO, shoppingCartLine);
            shoppingCartLine.setProduct(ProductMapper.toProduit(shoppingCartLineDTO.getProduct()));
            if(shoppingCartLineDTO.getVariant() != null) {
                shoppingCartLine.setVariant(VariantMapper.toVariant(shoppingCartLineDTO.getVariant()));
            }
            this.shoppingCartLineRepository.save(shoppingCartLine);
            return shoppingCartLine;
        } else
            throw new RuntimeException("Une erreure s'est produite lors de la modification de la ligne du shoppingCart");
    }

    public Long deleteShoppingCartLine(String currentUsername, Long id) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        ShoppingCartLine shoppingCartLine = getShoppingCartLine(id);
        if (userDTO != null && shoppingCartLine != null) {
            userDTO.getShoppingCart().getShoppingCartLines().remove(ShoppingCartLineMapper.toShoppingCartLineDTO(shoppingCartLine));
            userService.save(UserMapper.toUser(userDTO));
            return id;
        } else throw new NotFoundException("La ligne n'existe pas");
    }

    public boolean isContainInShoppingCart(Long a, Long b) {
        return a.longValue() == b.longValue();
    }
}
