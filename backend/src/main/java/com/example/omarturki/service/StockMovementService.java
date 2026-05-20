package com.example.omarturki.service;

import com.example.omarturki.model.StockMovement;
import com.example.omarturki.reposority.StockMovementRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;

    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    public List<StockMovement> getAllMovements() {
        return stockMovementRepository.findAll();
    }

    public StockMovement saveMovement(StockMovement movement) {
        return stockMovementRepository.save(movement);
    }
}
