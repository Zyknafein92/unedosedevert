package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.TagsCategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;

import com.openclassroom.projet12.mapper.TagsCategorieMapper;
import com.openclassroom.projet12.model.TagsCategorie;
import com.openclassroom.projet12.respository.TagsCaterogieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsCategorieService {

    @Autowired
    private TagsCaterogieRepository tagsCategorieRepository;

    @Autowired
    private TagsCategorieMapper tagsCategorieMapper;

    public List<TagsCategorie> getTagsCategories() {
        return tagsCategorieRepository.findAll();
    }

    public Optional<TagsCategorie> getTagsCategorie(Long id) {
        return tagsCategorieRepository.findById(id);
    }

    public TagsCategorie addTagsCategorie(TagsCategorieDTO tagsCategorieDTO) {
        return tagsCategorieRepository.save(tagsCategorieMapper.tagCategorieDTOtoTagsCategorie(tagsCategorieDTO));
    }

    public TagsCategorie updateTagsCategorie(TagsCategorieDTO tagsCategorieDTO) {
        Optional<TagsCategorie> tagsCategorieOptional = getTagsCategorie(tagsCategorieDTO.getId());
        TagsCategorie tagsCategorie = null;

        if (tagsCategorieOptional.isPresent()) {
            tagsCategorie = TagsCategorie.builder()
                    .id(tagsCategorieOptional.get().getId())
                    .name(tagsCategorieOptional.get().getName())
                    .build();
        }
        if (tagsCategorie == null) throw new NotFoundException("La catégorie de tag n'existe pas");
        tagsCategorieMapper.updateTagsCategorieFromTagsCategorieDTO(tagsCategorieDTO, tagsCategorie);
        return tagsCategorieRepository.save(tagsCategorie);
    }

    public Long deleteTagsCategorie(Long id) {
        tagsCategorieRepository.deleteById(id);
        return id;
    }
}
