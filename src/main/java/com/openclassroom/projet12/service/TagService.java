package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotEmptyException;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.TagMapper;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Tag;
import com.openclassroom.projet12.respository.ProductRepository;
import com.openclassroom.projet12.respository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final ProductRepository productRepository;


    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByIds(List<Long> ids) {
        return tagRepository.findAllById(ids);
    }

    public Page<TagDTO> getTagPage(Pageable pageable) {
        return tagRepository.findAll(pageable)
                .map(TagMapper::toDTO);
    }
    public Tag getTag(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("Le tag recherché n'a pas été trouvé"), ErrorCode.TAG_NOT_FOUND_ERROR));
    }

    public Tag addTag(TagDTO tagDTO) {
        return tagRepository.save(TagMapper.toTag(tagDTO));
    }

    public Tag updateTag(TagDTO tagDTO) {
        Tag tag = getTag(tagDTO.getId());
        TagMapper.update(tagDTO, tag);
        return tagRepository.save(tag);
    }

    public Long deleteTag(Long id) {
        List<Product> list = productRepository.getProductsByTagId(id);
        if(!list.isEmpty()) {
            throw new NotEmptyException("Le tag est toujours lié à un produit", ErrorCode.PRODUCT_LINKED_ERROR);
        }
        tagRepository.deleteById(id);
        return id;
    }

    public Tag findByName(String name) {
       return tagRepository.findTagByName(name);
    }
}
