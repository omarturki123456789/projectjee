package com.example.omarturki.controller;

import com.example.omarturki.model.StockMovement;
import com.example.omarturki.service.StockMovementService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {
    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping
    public List<StockMovement> getAllMovements() {
        return stockMovementService.getAllMovements();
    }

    @PostMapping
    public StockMovement createMovement(@RequestBody StockMovement movement) {
        return stockMovementService.saveMovement(movement);
    }
}
