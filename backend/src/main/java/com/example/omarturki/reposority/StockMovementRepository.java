package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omarturki.model.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
