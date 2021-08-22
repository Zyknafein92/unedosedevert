package com.openclassroom.projet12.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    String subCategorie;
    String categorie;
    String tag;
    String label;
    boolean reduction;
    String query;
}
