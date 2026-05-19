package com.example.omarturki.controller;

import com.example.omarturki.model.OrderStatus;
import com.example.omarturki.service.ClientService;
import com.example.omarturki.service.LivraisonService;
import com.example.omarturki.service.OrderService;
import com.example.omarturki.service.PaiementService;
import com.example.omarturki.service.ProductService;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final ProductService productService;
    private final LivraisonService livraisonService;
    private final PaiementService paiementService;

    public DashboardController(OrderService orderService,
                               ClientService clientService,
                               ProductService productService,
                               LivraisonService livraisonService,
                               PaiementService paiementService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.productService = productService;
        this.livraisonService = livraisonService;
        this.paiementService = paiementService;
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalOrders", orderService.countAll());
        stats.put("pendingOrders", orderService.countByStatut(OrderStatus.EN_ATTENTE));
        stats.put("totalRevenue", paiementService.getTotalRevenue());
        stats.put("totalClients", clientService.countAll());
        stats.put("lowStockProducts", productService.countLowStock());
        stats.put("pendingDeliveries", livraisonService.countPending());
        return stats;
    }
}
