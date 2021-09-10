package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.LabelDTO;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotEmptyException;
import com.openclassroom.projet12.exceptions.NotFoundException;

import com.openclassroom.projet12.mapper.LabelMapper;
import com.openclassroom.projet12.model.Label;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.respository.LabelRepository;
import com.openclassroom.projet12.respository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;
    private final ProductRepository productRepository;

    public List<Label> getLabels() {
        return labelRepository.findAll();
    }

    public Page<LabelDTO> getLabelPage(Pageable pageable) {
        return labelRepository.findAll(pageable)
                .map(LabelMapper::toDTO);
    }

    public Label getLabel(Long id) {
        return labelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le label n'existe pas", ErrorCode.LABEL_NOT_FOUND_ERROR));
    }

    public Label addLabel(LabelDTO labelDTO) {
        return labelRepository.save(LabelMapper.toLabel(labelDTO));
    }

    public Label updateLabel(LabelDTO labelDTO) {
      Label label = getLabel(labelDTO.getId());
      LabelMapper.update(labelDTO, label);
      return labelRepository.save(label);
    }

    public Long deleteLabel(Long id) {
        List<Product> list = productRepository.getProductByLabelId(id);
        if(!list.isEmpty()) {
            throw new NotEmptyException("Le label est toujours lié à un produit", ErrorCode.PRODUCT_LINKED_ERROR);
        }
        labelRepository.deleteById(id);
        return id;
    }

    public List<Label> getLabelsByIds(List<Long> ids) {
        return labelRepository.findAllById(ids);
    }
}
