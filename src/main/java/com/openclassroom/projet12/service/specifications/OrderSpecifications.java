package com.openclassroom.projet12.service.specifications;

import com.openclassroom.projet12.model.Order;
import com.openclassroom.projet12.model.OrderStatus;
import com.openclassroom.projet12.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Component
public class OrderSpecifications {

    public Specification<Order> orderByOrderNumberSpecification(String orderNumber) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( orderNumber != null) return criteriaBuilder.equal(root.get("orderNumber"), orderNumber);
            return criteriaBuilder.and();
        });
    }

    /*
    Select * from Order  outer join (left join) user on order.user_id = user.id
        where (select count(*) from User where user.email = email) > 0
     */
    public Specification<Order> ordersByUserIdSpecification(String email) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Subquery<Order> orderSubquery = criteriaQuery.subquery(Order.class);
            Root<User> rootUser = orderSubquery.from(User.class);
            Join<User, Order> userOrders = rootUser.join("orders");
            orderSubquery.select(userOrders).where(criteriaBuilder.equal(rootUser.get("email"), email));
            return criteriaBuilder.exists(orderSubquery);
        });
    }

    public Specification<Order> ordersByOrderStatusSpecification(OrderStatus orderStatus) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if ( orderStatus != null) return criteriaBuilder.equal(root.get("orderStatus"), orderStatus);
            return criteriaBuilder.and();
        });
    }
}
