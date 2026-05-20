package com.example.omarturki.service;

import com.example.omarturki.model.Order;
import com.example.omarturki.model.OrderStatus;
import com.example.omarturki.reposority.OrderRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Order saveOrder(Order order) {
        // Calcul automatique du montant total si des lignes sont présentes
        if (order.getLignes() != null && !order.getLignes().isEmpty()) {
            double total = order.getLignes().stream()
                    .mapToDouble(item -> item.getPrixUnitaire() * item.getQuantite())
                    .sum();
            order.setMontantTotal(total);
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existing = getOrderById(id);
        existing.setStatut(order.getStatut());
        existing.setClient(order.getClient());
        existing.setDate(order.getDate());
        if (order.getMontantTotal() != null) {
            existing.setMontantTotal(order.getMontantTotal());
        }
        return orderRepository.save(existing);
    }

    public Order updateStatus(Long id, OrderStatus statut) {
        Order order = getOrderById(id);
        order.setStatut(statut);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public long countByStatut(OrderStatus statut) {
        return orderRepository.countByStatut(statut);
    }

    public long countAll() {
        return orderRepository.count();
    }
}
