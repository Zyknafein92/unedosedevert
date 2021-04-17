package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ReductionMapper;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.respository.ProduitRepository;
import com.openclassroom.projet12.respository.ReductionRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class ReductionService {

    private final ReductionRepository reductionRepository;
    private final ProduitRepository produitService;

    /**
     * CRUD
     */

    public List<Reduction> getReductions() {
        return reductionRepository.findAll();
    }

    public Reduction getReduction(Long id) {
        return reductionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le reduction recherché n'a pas été trouvé"));
    }

    public ReductionDTO findReductionByProduitId(Long id) {
        return ReductionMapper.toReductionDTO(reductionRepository.findReductionsByProduitId(id));
    }

    public Reduction addReduction(ReductionDTO reductionDTO) {
        Produit produit = this.produitService.findById(reductionDTO.getProduitID())
                .orElseThrow(() -> new NotFoundException("Le produit n'existe pas !"));

        Reduction reduction = ReductionMapper.toReduction(reductionDTO);
        reduction.setProduit(produit);
        this.reductionRepository.save(reduction);
        produit.setReduction(reduction);
        this.produitService.save(produit);
       return reduction;

    }

    public Reduction updateReduction(ReductionDTO reductionDTO) {
        Reduction reduction = getReduction(reductionDTO.getId());
        ReductionMapper.update(reductionDTO, reduction);
        return reductionRepository.save(reduction);
    }

    public void deleteReduction(Long id) {
        Reduction reduction = getReduction(id);
        Produit produit = produitService.getOne(reduction.getProduit().getId());
        produit.setReduction(null);
        produit.getVariants().forEach(v -> v.setPrixReduction(null));
        this.produitService.save(produit);
        reductionRepository.deleteById(id);
    }

    /**
    * Utils
     */

    private void applyReduction(Produit produit) {
        produit.getVariants().forEach(v -> v.setPrixReduction(calculateReduction(v.getPrix(),produit.getReduction().getPourcentageRemise())));
        produitService.save(produit);
    }

    private void removeReduction(Produit produit) {
        deleteReduction(produit.getReduction().getId());
    }

    private double calculateReduction(Double prix, Double reduction) {
        return prix - (prix * reduction / 100);
    }


    /**
     *  Batch BDD
     */

    //@Scheduled(cron= "0 0 0 * * *") //tous les jours à minuit.
    @Scheduled(fixedDelay = 120000) // toutes les 2 minutes pour démo.
    @Transactional
    public void checkReduction() {
        LocalDate date = LocalDate.now();
        List<Reduction> reductionList = reductionRepository.findReductionByDate(date);

        for (Reduction r : reductionList) {
            Produit produit = produitService.findById(r.getProduit().getId())
                    .orElseThrow(() -> new NotFoundException("Le produit n'a pas été trouvé"));
            applyReduction(produit);
        }
    }
    //@Scheduled(cron= "0 0 0 * * *") //tous les jours à minuit.
    @Scheduled(fixedDelay = 120000) // toutes les 2 minutes pour démo.
    @Transactional
    public void checkReservationOutDated() {
        LocalDate date = LocalDate.now();
        List<Reduction> reductionList = reductionRepository.findOutDatedReductionByDate(date);

        for(Reduction reduction : reductionList) {
            Produit produit = produitService.findById(reduction.getProduit().getId())
                    .orElseThrow(() -> new NotFoundException("Le produit n'a pas été trouvé"));
            removeReduction(produit);
        }
    }
}
