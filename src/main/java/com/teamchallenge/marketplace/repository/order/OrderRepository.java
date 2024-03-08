package com.teamchallenge.marketplace.repository.order;

import com.teamchallenge.marketplace.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.product WHERE o.user.id = :id")
    List<Order> getAllWithProductByUserId(int id);
}
