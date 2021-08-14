package com.openclassroom.projet12.respository;


import com.openclassroom.projet12.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> , JpaSpecificationExecutor<Order> {

    Page<Order> findAllByUserId(Long id, Pageable pageable);
    Order findByOrderNumber(String orderNumber);


}
