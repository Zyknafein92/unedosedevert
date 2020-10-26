package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.PanierLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierLigneRepository extends JpaRepository<PanierLigne, Long> {
}
