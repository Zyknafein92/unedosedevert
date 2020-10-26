package com.openclassroom.projet12.mapper;
import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.model.Adresse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdresseMapper {

    Adresse adresseDTOtoAdresse(AdresseDTO adresseDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Adresse updateAdresseFromAdresseDTO(AdresseDTO adresseDTO, @MappingTarget Adresse adresse);

}
