package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {
}
