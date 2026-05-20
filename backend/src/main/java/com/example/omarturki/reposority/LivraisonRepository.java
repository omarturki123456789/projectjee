package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omarturki.model.Livraison;
import com.example.omarturki.model.LivraisonStatus;
import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    long countByStatut(LivraisonStatus statut);
}
