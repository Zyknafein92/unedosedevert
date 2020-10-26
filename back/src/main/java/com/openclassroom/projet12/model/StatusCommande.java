package fr.openclassroom.epicerie.back.model;

import lombok.Getter;

@Getter
public enum StatusCommande {
    ATTENTE("En attente de validation."),
    VALIDE("Commande validée, en attente de prépraration."),
    PREPARATION("Commande en cours de préparation."),
    ATTENTE_LIVRAISON("Commande prête a être expédiée"),
    LIVRAISON("Commande en cours de livraison."),
    TERMINE("Commande livrée.");

    private final String description;

    StatusCommande(String description) {
        this.description = description;
    }
}
