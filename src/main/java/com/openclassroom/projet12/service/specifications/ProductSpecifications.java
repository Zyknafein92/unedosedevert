package com.openclassroom.projet12.service.specifications;

import com.openclassroom.projet12.model.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

@Component
public class ProductSpecifications {

    //categorie
    public Specification<Product> categorieSpecification(String categorieName) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Path<Categorie> category = root.get("categorie");
            Predicate containsName = criteriaBuilder.like(criteriaBuilder.upper(category.get("name")), "%" + categorieName + "%");
            return containsName;
        });
    }

    //sous-categorie
    public Specification<Product> subCategorieSpecification(String subCategorieName) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
          Path<SubCategorie> subCategoriePath = root.get("subCategorie");
          Predicate containsName = criteriaBuilder.like(criteriaBuilder.upper(subCategoriePath.get("name")), "%" + subCategorieName.toUpperCase() + "%");
            return containsName;
        });
    }

    //tag : Product -> Tag // select * from produit where (select count(*) from tag where tag.produitId= produit.id and tag.name = ?tag)>0
    public Specification<Product> tagSpecification(String tagName) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            // criteriaQuery.distinct(true);
            Subquery<Tag> tagSubquery = criteriaQuery.subquery(Tag.class);
            Root<Tag> tagRoot = tagSubquery.from(Tag.class);
            tagSubquery.select(tagRoot);
            Expression<Collection<Tag>> tags = root.get("tags");

            Predicate namePredicate = criteriaBuilder.equal(tagRoot.get("name"), tagName);
            Predicate tagProductPredicate = criteriaBuilder.isMember(tagRoot, tags);
            Subquery<Tag> productContainTagQuery = tagSubquery.where(namePredicate, tagProductPredicate);
            return criteriaBuilder.exists(productContainTagQuery);
        });
    }

    //label
    public Specification<Product> labelSpecification(String labelName) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Subquery<Label> labelSubquery = criteriaQuery.subquery(Label.class);
            Root<Label> labelRoot = labelSubquery.from(Label.class);
            labelSubquery.select(labelRoot);
            Expression<Collection<Label>> labels = root.get("labels");

            Predicate namePredicate = criteriaBuilder.equal(labelRoot.get("name"), labelName);
            Predicate labelProductPredicate = criteriaBuilder.isMember(labelRoot, labels);
            Subquery<Label> productContainLabelQuery = labelSubquery.where(namePredicate, labelProductPredicate);
            return criteriaBuilder.exists(productContainLabelQuery);
        });
    }

    public Specification<Product> reductionSpecification() {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("reduction")));
    }

    public Specification<Product> querySpecification(String query) {
        return Objects.requireNonNull(tagSpecification(query).or(categorieSpecification(query))).or(subCategorieSpecification(query).or(labelSpecification(query)));
    }
}
