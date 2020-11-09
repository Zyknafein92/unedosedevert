package com.openclassroom.projet12.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public enum  RoleName {
    ROLE_USER,
    ROLE_ADMIN
}
