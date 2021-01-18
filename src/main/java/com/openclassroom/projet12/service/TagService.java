package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.TagMapper;
import com.openclassroom.projet12.model.Tag;
import com.openclassroom.projet12.respository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTag(Long id) {
        return tagRepository.findById(id);
    }

    public Tag addTag(TagDTO tagDTO) {
        return tagRepository.save(tagMapper.tagDTOtoTag(tagDTO));
    }

    public Tag updateTag(TagDTO tagDTO) {
        Optional<Tag> tagOptional = getTag(tagDTO.getId());
        Tag tag = null;

        if (tagOptional.isPresent()) {
            tag = Tag.builder()
                    .id(tagOptional.get().getId())
                    .name(tagOptional.get().getName())
                    .build();
        }
        if (tag == null) throw new NotFoundException("Le tag recherché n'a pas été trouvé");
        tagMapper.updateTagFromTagDTO(tagDTO, tag);
        return tagRepository.save(tag);
    }

    public Long deleteTag(Long id) {
        tagRepository.deleteById(id);
        return id;
    }
}
