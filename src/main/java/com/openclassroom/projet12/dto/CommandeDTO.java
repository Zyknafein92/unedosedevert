package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.StatusCommande;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CommandeDTO {

    private Long id;

    private UserDTO userDTO;

    private AdresseDTO adresseDTO;

    private List<VariantCommandeDTO> variantDTOList;

    private LocalDateTime date;

    private Double total;

    private StatusCommande statusCommande;

//    private ModeReglement modeReglement;

    private Boolean livraison;
}
