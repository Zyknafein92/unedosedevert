package fr.openclassroom.epicerie.back.model;


import lombok.Getter;

@Getter
public enum ModeReglement {
    PAYPAL("Règlement via Paypal"),
    BANCAIRE("Règlement via Carte Bleue");

    private final String description;

    ModeReglement(String description) {
        this.description = description;
    }
}
