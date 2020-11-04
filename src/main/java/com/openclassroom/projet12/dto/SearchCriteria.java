package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    Categorie categorie;
    Type type;
    String query;
}
