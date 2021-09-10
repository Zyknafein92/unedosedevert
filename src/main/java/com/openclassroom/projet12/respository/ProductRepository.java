package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCategorie(Categorie categorie);
    List<Product> findAllByType(Type type);
    List<Product> findAllBySubCategorie(SubCategorie subCategorie);
    @Query("select p from Product p inner join p.labels label where label.id = :id ")
    List<Product> getProductByLabelId(Long id);
    @Query("select p from Product p inner join p.tags tag where tag.id = :id ")
    List<Product> getProductsByTagId(Long id);
}
