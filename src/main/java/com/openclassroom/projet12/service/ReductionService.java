package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ReductionMapper;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.respository.ProductRepository;
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
    private final ProductRepository produitService;

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
        return ReductionMapper.toReductionDTO(reductionRepository.findReductionsByProductId(id));
    }

    public Reduction addReduction(ReductionDTO reductionDTO) {
        Product product = this.produitService.findById(reductionDTO.getProduitID())
                .orElseThrow(() -> new NotFoundException("Le product n'existe pas !"));

        Reduction reduction = ReductionMapper.toReduction(reductionDTO);
        reduction.setProduct(product);
        this.reductionRepository.save(reduction);
        product.setReduction(reduction);
        this.produitService.save(product);
       return reduction;

    }

    public Reduction updateReduction(ReductionDTO reductionDTO) {
        Reduction reduction = getReduction(reductionDTO.getId());
        ReductionMapper.update(reductionDTO, reduction);
        return reductionRepository.save(reduction);
    }

    public void deleteReduction(Long id) {
        Reduction reduction = getReduction(id);
        Product product = produitService.getOne(reduction.getProduct().getId());
        product.setReduction(null);
        product.getVariants().forEach(v -> v.setReductionPrice(null));
        this.produitService.save(product);
        reductionRepository.deleteById(id);
    }

    /**
    * Utils
     */

    private void applyReduction(Product product) {
        product.getVariants().forEach(v -> v.setReductionPrice(calculateReduction(v.getPrice(), product.getReduction().getPercentageReduction())));
        produitService.save(product);
    }

    private void removeReduction(Product product) {
        deleteReduction(product.getReduction().getId());
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
            Product product = produitService.findById(r.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException("Le product n'a pas été trouvé"));
            applyReduction(product);
        }
    }
    //@Scheduled(cron= "0 0 0 * * *") //tous les jours à minuit.
    @Scheduled(fixedDelay = 120000) // toutes les 2 minutes pour démo.
    @Transactional
    public void checkReservationOutDated() {
        LocalDate date = LocalDate.now();
        List<Reduction> reductionList = reductionRepository.findOutDatedReductionByDate(date);

        for(Reduction reduction : reductionList) {
            Product product = produitService.findById(reduction.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException("Le product n'a pas été trouvé"));
            removeReduction(product);
        }
    }
}
