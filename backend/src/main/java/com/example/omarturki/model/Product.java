package com.example.omarturki.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Double prix;
    private Integer quantiteStock;
    private Integer minQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<OrderItem> orderItems;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<StockMovement> stockMovements;
}
