package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor {
    List<Product> findAllByCategorieAndType(Categorie categorie, Type type);
    List<Product> findAllByCategorie(Categorie categorie);
    List<Product> findAllByType(Type type);
}
