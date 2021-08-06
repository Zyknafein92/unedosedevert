package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.AdressDTO;
import com.openclassroom.projet12.dto.UserDTO;
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

    //todo: vérification des droits utilisateurs
    public Adress getAdresse(Long id) {
        return adressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("L'adresse n'existe pas !"));
    }

    public Adress addAdresse(AdressDTO adressDTO, String username) {

        UserDTO userDTO = userService.findByEmail(username);

        if (userDTO != null) {
            if (!checkDelivryStatus(userDTO)) adressDTO.setDelivery(true);
          //  if (!checkBillingStatus(userDTO)) adressDTO.setFacturation(true);

            Adress adress = AdressMapper.toAdresse(adressDTO);
            userDTO.getAdresses().add(adressDTO);
            User userEntity = UserMapper.toUser(userDTO);
            userService.save(userEntity);
            return adress;

        } else throw new RuntimeException("Une erreure s'est produite lors de la création de l'adresse");
    }

    public Adress updateAdresse(AdressDTO adressDTO, String username) {
        UserDTO userDTO = userService.findByEmail(username);
        Adress adress = getAdresse(adressDTO.getId());
        if(userDTO != null && adress != null) {
            if (adress.getDelivery() && checkDelivryStatus(userDTO)) {
                updateUserAdresseDeliveryStatus(userDTO, adress);
            }
            if(adress.getBilling() && checkBillingStatus(userDTO)) {
                updateUserAdresseBillingStatus(userDTO, adress);
            }
            AdressMapper.update(adressDTO, adress);
            return adressRepository.save(adress);
        }
        else throw new RuntimeException("Une erreure s'est produite lors de la modification de l'adress");
    }

    public Long deleteAdresse(Long id, String username) {
        UserDTO user = userService.findByEmail(username);
        Adress adress = getAdresse(id);
        if (adress != null) {
            user.getAdresses().remove(AdressMapper.toAdresseDTO(adress));
            User userEntity = UserMapper.toUser(user);
            userService.save(userEntity);
        } else throw new NotFoundException("L'adress n'existe pas");
        return id;
    }

    private boolean checkDelivryStatus(UserDTO userDTO) {
       return userDTO.getAdresses().stream().anyMatch(AdressDTO::getDelivery);
    }

    private boolean checkBillingStatus(UserDTO userDTO) {
        return userDTO.getAdresses().stream().anyMatch(AdressDTO::getDelivery);
    }

    private void updateUserAdresseBillingStatus(UserDTO userDTO, Adress adress) {
        for (AdressDTO adressDTO : userDTO.getAdresses()) {
            if (!adressDTO.getId().equals(adress.getId()) && adressDTO.getBilling()) {
                adressDTO.setBilling(false);
                adressRepository.save(AdressMapper.toAdresse(adressDTO));
            }
        }

//        userDTO.getAdresses().stream()
//                .filter( adresseDTO -> !adresseDTO.getId().equals(adress.getId()) && adresseDTO.getFacturation())
//                .forEach(adresseDTO -> { adresseDTO.setFacturation(false); adresseRepository.save(AdresseMapper.toAdresse(adresseDTO));});
    }

    private void updateUserAdresseDeliveryStatus(UserDTO userDTO, Adress adress) {
        for (AdressDTO adressDTO : userDTO.getAdresses()) {
            if (!adressDTO.getId().equals(adress.getId()) && adressDTO.getDelivery()) {
                adressDTO.setBilling(false);
                adressRepository.save(AdressMapper.toAdresse(adressDTO));
            }
        }
    }

}
