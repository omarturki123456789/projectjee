package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omarturki.model.Order;
import com.example.omarturki.model.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {
    long countByStatut(OrderStatus statut);
}
