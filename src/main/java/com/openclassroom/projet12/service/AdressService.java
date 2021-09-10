package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.AdressDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.CreationError;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.AdressMapper;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.Adress;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdressService {

    private final AdressRepository adressRepository;
    private final UserService userService;

    public Adress getAddress(Long id) {
        return adressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("L'adresse n'existe pas !", ErrorCode.ADDRESS_NOT_FOUND));
    }

    public Adress addAddress(AdressDTO adressDTO, String username) {

        UserDTO userDTO = userService.findByEmail(username);

        if (userDTO != null) {
            Adress adress = AdressMapper.toAdresse(adressDTO);
            userDTO.getAdresses().add(adressDTO);
            User userEntity = UserMapper.toUser(userDTO);
            userService.save(userEntity);
            return adress;

        } else throw new CreationError("Une erreure s'est produite lors de la création de l'adresse", ErrorCode.ADDRESS_CREATION_ERROR);
    }

    public Adress updateAddress(AdressDTO adressDTO, String username) {
        UserDTO userDTO = userService.findByEmail(username);
        Adress adress = getAddress(adressDTO.getId());

        if (userDTO != null && adress != null) {

            if (adressDTO.getDelivery() != null) {
                adress.setDelivery(adressDTO.getDelivery());
            }
            if (adressDTO.getBilling() != null) {
                adress.setBilling(adressDTO.getBilling());
            }
            if (adress.getDelivery() || adress.getDelivery() != null && checkDeliveryStatus(userDTO)) {
                updateUserAddressDeliveryStatus(userDTO, adress);
            }
            if(adress.getBilling() || adress.getBilling() != null && checkBillingStatus(userDTO)) {
                updateUserAddressBillingStatus(userDTO, adress);
            }

            AdressMapper.update(adressDTO, adress);
            return adressRepository.save(adress);
        }
        else throw new CreationError("Une erreure s'est produite lors de la modification de l'adresse", ErrorCode.ADDRESS_UPDATE_ERROR);
    }

    public Long deleteAddress(Long id, String username) {
        UserDTO user = userService.findByEmail(username);
        Adress adress = getAddress(id);
        if (adress != null) {
            user.getAdresses().remove(AdressMapper.toAdresseDTO(adress));
            User userEntity = UserMapper.toUser(user);
            userService.save(userEntity);
        } else throw new NotFoundException("L'adresse n'existe pas !", ErrorCode.ADDRESS_NOT_FOUND);
        return id;
    }

    private boolean checkDeliveryStatus(UserDTO userDTO) {
        return userDTO.getAdresses().stream().anyMatch(AdressDTO::getDelivery);
    }

    private boolean checkBillingStatus(UserDTO userDTO) {
        return userDTO.getAdresses().stream().anyMatch(AdressDTO::getDelivery);
    }

    private void updateUserAddressBillingStatus(UserDTO userDTO, Adress adress) {
        for (AdressDTO adressDTO : userDTO.getAdresses()) {
            if (!adressDTO.getId().equals(adress.getId()) && adressDTO.getBilling()) {
                adressDTO.setBilling(false);
                adressRepository.save(AdressMapper.toAdresse(adressDTO));
            }
        }

    }

    private void updateUserAddressDeliveryStatus(UserDTO userDTO, Adress adress) {
        for (AdressDTO adressDTO : userDTO.getAdresses()) {
            if (!adressDTO.getId().equals(adress.getId()) && adressDTO.getDelivery()) {
                adressDTO.setDelivery(false);
                adressRepository.save(AdressMapper.toAdresse(adressDTO));
            }
        }
    }

}
