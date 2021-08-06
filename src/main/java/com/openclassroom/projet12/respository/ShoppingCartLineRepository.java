package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.ShoppingCartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartLineRepository extends JpaRepository<ShoppingCartLine, Long> {
}
