package com.example.omarturki.reposority;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omarturki.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByQuantiteStockLessThan(Integer threshold);
}
