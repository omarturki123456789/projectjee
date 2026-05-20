package com.example.omarturki.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "livraisons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order commande;

    private String transporteur;

    private LocalDate dateLivraison;
    private Double cout;

    @Enumerated(EnumType.STRING)
    private LivraisonStatus statut;
}
