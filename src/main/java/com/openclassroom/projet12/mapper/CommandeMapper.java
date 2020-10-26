package com.openclassroom.projet12.mapper;



import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.model.Commande;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommandeMapper {

        Commande commandeDTOtoCommande(CommandeDTO commandeDTO);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
                nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
        Commande updateCommandeFromCommandeDTO(CommandeDTO commandeDTO, @MappingTarget Commande commande);
}
