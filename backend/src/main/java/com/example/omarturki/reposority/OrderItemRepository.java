package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omarturki.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
