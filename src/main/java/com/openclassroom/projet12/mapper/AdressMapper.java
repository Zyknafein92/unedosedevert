package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdressDTO;
import com.openclassroom.projet12.model.Adress;
import org.springframework.stereotype.Component;

@Component
public class AdressMapper {

    public static Adress toAdresse(AdressDTO dto) {
        return Adress.builder()
                .id(dto.getId())
                .gender(dto.getGender())
                .adressName(dto.getAdressName())
                .lastName(dto.getLastName())
                .firstName(dto.getFirstName())
                .phone(dto.getPhone())
                .digicode(dto.getDigicode())
                .interphone(dto.getInterphone())
                .appartNumber(dto.getAppartNumber())
                .floor(dto.getFloor())
                .building(dto.getBuilding())
                .number(dto.getNumber())
                .street(dto.getStreet())
                .postalCode(dto.getPostalCode())
                .city(dto.getCity())
                .information(dto.getInformation())
                .delivery(dto.getDelivery())
                .billing(dto.getBilling())
                .build();
    }

    public static AdressDTO toAdresseDTO (Adress adress) {
        return AdressDTO.builder()
                .id(adress.getId())
                .gender(adress.getGender())
                .adressName(adress.getAdressName())
                .lastName(adress.getLastName())
                .firstName(adress.getFirstName())
                .phone(adress.getPhone())
                .digicode(adress.getDigicode())
                .appartNumber(adress.getAppartNumber())
                .interphone(adress.getInterphone())
                .floor(adress.getFloor())
                .building(adress.getBuilding())
                .number(adress.getNumber())
                .street(adress.getStreet())
                .postalCode(adress.getPostalCode())
                .city(adress.getCity())
                .information(adress.getInformation())
                .delivery(adress.getDelivery())
                .billing(adress.getBilling())
                .build();
    }

    public static void update(AdressDTO dto, Adress entity) {
        entity.setGender(dto.getGender());
        entity.setAdressName(dto.getAdressName());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setPhone(dto.getPhone());
        entity.setDigicode(dto.getDigicode());
        entity.setInterphone(dto.getInterphone());
        entity.setAppartNumber(dto.getAppartNumber());
        entity.setFloor(dto.getFloor());
        entity.setBuilding(dto.getBuilding());
        entity.setNumber(dto.getNumber());
        entity.setStreet(dto.getStreet());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCity(dto.getCity());
        entity.setInformation(dto.getInformation());
        entity.setDelivery(dto.getDelivery());
        entity.setBilling(dto.getBilling());
    }
}
