package com.openclassroom.projet12.service.specifications;

import com.openclassroom.projet12.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductSpecifications {

    //tag
    public Specification<Product> tagSpecification(String tag) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( tag != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("tag")), "%" + tag.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }
    //categorie
    public Specification<Product> categorieSpecification(String categorie) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( categorie != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("categorie")), "%" + categorie.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }

    //sous-categorie
    public Specification<Product> sousCategorieSpecification(String sousCategorie) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( sousCategorie != null) return criteriaBuilder.like(criteriaBuilder.upper(root.get("subCategorie")), "%" + sousCategorie.toUpperCase() + "%");
            return criteriaBuilder.and();
        });
    }

    public Specification<Product> querySpecification(String query) {
        if(query == null) return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and());
        return Objects.requireNonNull(tagSpecification(query).or(categorieSpecification(query))).or(sousCategorieSpecification(query));
    }
}
