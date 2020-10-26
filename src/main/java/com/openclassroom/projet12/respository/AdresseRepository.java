package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
