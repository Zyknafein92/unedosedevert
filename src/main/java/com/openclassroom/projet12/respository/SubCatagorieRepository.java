package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.SubCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCatagorieRepository extends JpaRepository<SubCategorie, Long> {
}
