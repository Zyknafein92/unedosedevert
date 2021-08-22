package com.openclassroom.projet12.respository;

import com.openclassroom.projet12.model.OrderAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAdressRepository extends JpaRepository<OrderAdress, Long> {
}
