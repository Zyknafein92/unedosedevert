package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction,Long> {
}
