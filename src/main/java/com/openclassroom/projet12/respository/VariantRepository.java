package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.Variant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VariantRepository extends JpaRepository<Variant,Long> {
    List<Variant> findAllByProduitId(Long produit_id);
}
