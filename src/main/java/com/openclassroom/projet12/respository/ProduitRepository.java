package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>, JpaSpecificationExecutor {
    List<Produit> findAllByCategorieAndType(Categorie categorie, Type type);
    List<Produit> findAllByCategorie(Categorie categorie);
    List<Produit> findAllByType(Type type);
}
