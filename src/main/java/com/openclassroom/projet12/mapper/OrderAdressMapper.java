package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdressDTO;

import com.openclassroom.projet12.model.OrderAdress;
import org.springframework.stereotype.Component;

@Component
public class OrderAdressMapper {

    public static OrderAdress AdressDTOtoOrderAdress(AdressDTO adressDTO) {
        return OrderAdress.builder()
                .gender(adressDTO.getGender())
                .adressName(adressDTO.getAdressName())
                .lastName(adressDTO.getLastName())
                .firstName(adressDTO.getFirstName())
                .phone(adressDTO.getPhone())
                .digicode(adressDTO.getDigicode())
                .interphone(adressDTO.getInterphone())
                .appartNumber(adressDTO.getAppartNumber())
                .floor(adressDTO.getFloor())
                .building(adressDTO.getBuilding())
                .number(adressDTO.getNumber())
                .street(adressDTO.getStreet())
                .postalCode(adressDTO.getPostalCode())
                .city(adressDTO.getCity())
                .information(adressDTO.getInformation())
                .delivery(adressDTO.getDelivery())
                .billing(adressDTO.getBilling())
                .build();
    }
}
