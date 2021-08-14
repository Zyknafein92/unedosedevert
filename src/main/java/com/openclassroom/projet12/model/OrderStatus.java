package com.openclassroom.projet12.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ATTENTE("En attente de validation."),
    VALIDE("Commande validée, en attente de prépraration."),
    INVALIDE("Paiement refusée"),
    PREPARATION("Commande en cours de préparation."),
    ATTENTE_LIVRAISON("Commande prête a être expédiée"),
    LIVRAISON("Commande en cours de livraison."),
    TERMINE("Commande livrée.");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
