package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omarturki.model.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
