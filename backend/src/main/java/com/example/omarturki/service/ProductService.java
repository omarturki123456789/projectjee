package com.example.omarturki.service;

import com.example.omarturki.model.Product;
import com.example.omarturki.reposority.ProductRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setNom(product.getNom());
        existing.setDescription(product.getDescription());
        existing.setPrix(product.getPrix());
        existing.setQuantiteStock(product.getQuantiteStock());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findByQuantiteStockLessThan(5);
    }

    public long countLowStock() {
        return productRepository.findByQuantiteStockLessThan(5).size();
    }
}
