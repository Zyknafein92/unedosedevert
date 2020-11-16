package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository <Categorie, Long> {
}
