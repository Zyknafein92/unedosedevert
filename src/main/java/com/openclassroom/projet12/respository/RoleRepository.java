package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Role;
import com.openclassroom.projet12.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleName roleName);

}
