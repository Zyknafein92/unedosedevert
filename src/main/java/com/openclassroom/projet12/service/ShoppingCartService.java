package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.ShoppingCartDTO;
import com.openclassroom.projet12.dto.ShoppingCartLineDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.ShoppingCartLine;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.ShoppingCartLineRepository;
import com.openclassroom.projet12.respository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartLineRepository shoppingCartLineRepository;
    private final UserService userService;


    public ShoppingCartDTO getPanier(String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            List<ShoppingCartLineDTO> shoppingCartLineDTOList =  userDTO.getShoppingCart().getShoppingCartLines();
            userDTO.getShoppingCart().setTotalPrice(shoppingCartLineDTOList.stream().mapToDouble(ShoppingCartLineDTO::getPrice).reduce(Double::sum).getAsDouble());
            return userDTO.getShoppingCart();
        } else throw new NotFoundException("Le shoppingCart n'existe pas !");
    }

    public ShoppingCart addToPanier(List<ShoppingCartLineDTO> shoppingCartLineDTOList, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            // creer shoppingCart dto
            // convertir vers shoppingCart
            for (ShoppingCartLineDTO shoppingCartLineDTO : shoppingCartLineDTOList) {
                userDTO.getShoppingCart().getShoppingCartLines().add(shoppingCartLineDTO);
            }
            ShoppingCart shoppingCart = ShoppingCartMapper.toPanier(userDTO.getShoppingCart());
            return shoppingCartRepository.save(shoppingCart);
        }
       else throw new RuntimeException("Une erreur s'est produite");
    }
//
//    public ShoppingCart updatePanier(ShoppingCartDTO panierDTO, String currentUsername) {
//        UserDTO userDTO = userService.findByEmail(currentUsername);
//        ShoppingCart shoppingCart = UserMapper.toUser(userDTO).getShoppingCart();
//        PanierMapper.update(panierDTO,shoppingCart);
//        return shoppingCart;
//    }


    // ShoppingCartLine //

//    public List<ShoppingCartLine> getShoppingCartLines() {
//        return panierLigneRepository.findAll();
//    }

    public ShoppingCartLine getPanierLigne(Long id) {
        return shoppingCartLineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La ligne du shoppingCart n'existe pas !"));
    }

    public ShoppingCartLine addPanierLigne(ShoppingCartLineDTO shoppingCartLineDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            ShoppingCartLine shoppingCartLine = ShoppingCartLineMapper.toPanierLigne(shoppingCartLineDTO);
            userDTO.getShoppingCart().getShoppingCartLines().add(shoppingCartLineDTO);
            User entityToSave = UserMapper.toUser(userDTO);
            userService.save(entityToSave);
            return shoppingCartLine;
        } else throw new RuntimeException("Une erreure s'est produite lors de la création de la ligne du shoppingCart");
    }

    public ShoppingCartLine updatePanierLigne(ShoppingCartLineDTO shoppingCartLineDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        ShoppingCartLine shoppingCartLine = getPanierLigne(shoppingCartLineDTO.getId());
        if (userDTO != null && shoppingCartLine != null) {
            ShoppingCartLineMapper.update(shoppingCartLineDTO, shoppingCartLine);
            shoppingCartLine.setProduct(ProductMapper.toProduit(shoppingCartLineDTO.getProduct()));
            shoppingCartLine.setVariant(VariantMapper.toVariant(shoppingCartLineDTO.getVariant()));
            this.shoppingCartLineRepository.save(shoppingCartLine);
            return shoppingCartLine;
        }
        else throw new RuntimeException("Une erreure s'est produite lors de la modification de la ligne du shoppingCart");
    }

    public Long deletePanierLigne(String currentUsername, Long id) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        ShoppingCartLine shoppingCartLine = getPanierLigne(id);
        if (userDTO != null && shoppingCartLine != null) {
            userDTO.getShoppingCart().getShoppingCartLines().remove(ShoppingCartLineMapper.toPanierLigneDTO(shoppingCartLine));
            userService.save(UserMapper.toUser(userDTO));
            return id;
        } else throw new NotFoundException("La ligne n'existe pas");
    }
}
