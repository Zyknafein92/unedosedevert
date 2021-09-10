package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findTagByName(String name);
}
