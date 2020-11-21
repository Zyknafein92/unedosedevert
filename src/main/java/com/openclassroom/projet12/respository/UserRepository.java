package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
