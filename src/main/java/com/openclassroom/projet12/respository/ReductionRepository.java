package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction,Long> {

    Reduction findReductionsByProductId(Long productId);

    @Query("select r from Reduction r where r.reductionStart = :date")
    List<Reduction> findReductionByDate(LocalDate date);

    @Query("select r from Reduction r where :date > r.reductionEnd")
    List<Reduction> findOutDatedReductionByDate(LocalDate date);

}
