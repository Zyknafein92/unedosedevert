package com.openclassroom.projet12.service.specifications;

import com.openclassroom.projet12.model.Produit;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProduitSpecifications {

    //tag
    public Specification<Produit> tagSpecification(String tag) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( tag != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("tag")), "%" + tag.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }
    //categorie
    public Specification<Produit> categorieSpecification(String categorie) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( categorie != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("categorie")), "%" + categorie.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }

    //sous-categorie
    public Specification<Produit> sousCategorieSpecification(String sousCategorie) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( sousCategorie != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("sousCategorie")), "%" + sousCategorie.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }

    public Specification<Produit> querySpecification(String query) {
        if(query == null) return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and());
        return Objects.requireNonNull(tagSpecification(query).or(categorieSpecification(query))).or(sousCategorieSpecification(query));
    }
}
