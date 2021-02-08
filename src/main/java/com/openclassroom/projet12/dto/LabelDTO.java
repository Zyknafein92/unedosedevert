package com.openclassroom.projet12.dto;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class LabelDTO {

    private Long id;

    private String name;

    private String photoURL;
}
