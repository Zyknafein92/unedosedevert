package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.LabelDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;

import com.openclassroom.projet12.mapper.LabelMapper;
import com.openclassroom.projet12.model.Label;
import com.openclassroom.projet12.respository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private LabelMapper labelMapper;

    public List<Label> getLabels() {
        return labelRepository.findAll();
    }

    public Page<LabelDTO> getLabelPage(Pageable pageable) {
        return labelRepository.findAll(pageable)
                .map(tagCat -> labelMapper.labelToLabelDTO(tagCat));
    }

    public Optional<Label> getLabel(Long id) {
        return labelRepository.findById(id);
    }

    public Label addLabel(LabelDTO labelDTO) {
        return labelRepository.save(labelMapper.labelDTOToLabel(labelDTO));
    }

    public Label updateLabel(LabelDTO labelDTO) {
        Optional<Label> labelOptional = getLabel(labelDTO.getId());
        Label label = null;

        if (labelOptional.isPresent()) {
            label = Label.builder()
                    .id(labelOptional.get().getId())
                    .name(labelOptional.get().getName())
                    .urlPhoto(labelOptional.get().getUrlPhoto())
                    .build();
        }
        if (label == null) throw new NotFoundException("La catégorie de tag n'existe pas");
        labelMapper.updateLabelFromLabelDTO(labelDTO, label);
        return labelRepository.save(label);
    }

    public Long deleteLabel(Long id) {
        labelRepository.deleteById(id);
        return id;
    }
}
