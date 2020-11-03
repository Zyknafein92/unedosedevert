package com.openclassroom.projet12.model;

import lombok.Getter;



@Getter
public enum Categorie {
    FRUITS("Fruit séchés et oléagineux"),
    GRAINES("Graines"),
    LEGUMINEUSE("Légumineuse"),
    RIZ("Riz"),
    PATES("Pâtes"),
    CEREALES("Céréales"),
    BISCUITS_SALE("Biscuits salés"),
    BISCUITS_SUCRES("Biscuits sucrés"),
    FARINE("Farine"),
    SUCRE("Sucre"),
    AIDES_CULINAIRES("Aides culinaires"),
    FLEUR_DE_SEL("Fleur de sel"),
    CONDIMENTS("Condiments"),
    EPICES("Epices"),
    INFUSIONS("Infusions"),
    THE("Thé"),
    CAFE("Café"),
    SAVON("Savon"),
    SHAMPOING("Shampoing"),
    MASQUE("Masque"),
    BIEN_ETRE("Bien-être"),
    LINGE("Linge"),
    VAISELLE("Vaiselle");

    private final String description;

    Categorie(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
