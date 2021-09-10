package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ReductionMapper;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Tag;
import com.openclassroom.projet12.respository.ProductRepository;
import com.openclassroom.projet12.respository.ReductionRepository;
import com.openclassroom.projet12.respository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class ReductionService {

    private static final String PROMO_TAG_NAME = "En promo !";

    private final ReductionRepository reductionRepository;
    private final ProductRepository produitService;
    private final TagService tagService;

    /**
     * CRUD
     */

    public List<Reduction> getReductions() {
        return reductionRepository.findAll();
    }

    public Reduction getReduction(Long id) {
        return reductionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("Le reduction recherché n'a pas été trouvé"), ErrorCode.REDUCTION_NOT_FOUND_ERROR));
    }

    public ReductionDTO findReductionByProductId(Long id) {
        Reduction reduction = reductionRepository.findReductionsByProductId(id);
        if (reduction != null) {
            return ReductionMapper.toReductionDTO(reduction);
        }
        return null;
    }

    public Reduction addReduction(ReductionDTO reductionDTO) {
        Product product = this.produitService.findById(reductionDTO.getProduitID())
                .orElseThrow(() -> new NotFoundException(("Le product n'existe pas !"), ErrorCode.PRODUCT_NOT_FOUND_ERROR));
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
        Tag tag = this.tagService.findByName(PROMO_TAG_NAME);
        product.getTags().remove(tag);
        this.produitService.save(product);
    }

    /**
    * Utils
     */

    private void applyReduction(Product product) {
        Tag tag = this.tagService.findByName(PROMO_TAG_NAME);
        product.getTags().add(tag);
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
    @Scheduled(fixedDelay = 60000) // toutes les minutes pour démo.
    @Transactional
    public void checkReduction() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        List<Reduction> reductionList = reductionRepository.findReductionByDate(date);

        for (Reduction r : reductionList) {
            Product product = produitService.findById(r.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException(("Le produit n'a pas été trouvé"), ErrorCode.PRODUCT_NOT_FOUND_ERROR));
            applyReduction(product);
        }
    }

    //@Scheduled(cron= "0 0 0 * * *") //tous les jours à minuit.
    @Scheduled(fixedDelay = 60000) // toutes les minutes pour démo.
    @Transactional
    public void checkReservationOutDated() {
        LocalDate date = LocalDate.now();
        List<Reduction> reductionList = reductionRepository.findOutDatedReductionByDate(date);

        for(Reduction reduction : reductionList) {
            Product product = produitService.findById(reduction.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException(("Le produit n'a pas été trouvé"), ErrorCode.PRODUCT_NOT_FOUND_ERROR));
            removeReduction(product);
        }
    }
}
