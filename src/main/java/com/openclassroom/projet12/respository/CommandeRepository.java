package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
