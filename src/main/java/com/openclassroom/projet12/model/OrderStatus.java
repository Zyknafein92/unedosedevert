package com.openclassroom.projet12.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ATTENTE("En attente de validation."),
    VALIDE("Order validée, en attente de prépraration."),
    PREPARATION("Order en cours de préparation."),
    ATTENTE_LIVRAISON("Order prête a être expédiée"),
    LIVRAISON("Order en cours de livraison."),
    TERMINE("Order livrée.");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
