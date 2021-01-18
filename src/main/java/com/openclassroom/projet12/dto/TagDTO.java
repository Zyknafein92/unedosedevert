package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDTO {

    private Long id;
    private String name;
}
