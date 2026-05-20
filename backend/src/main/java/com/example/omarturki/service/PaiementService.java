package com.example.omarturki.service;

import com.example.omarturki.model.Paiement;
import com.example.omarturki.reposority.PaiementRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaiementService {
    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public double getTotalRevenue() {
        return paiementRepository.findAll().stream()
                .mapToDouble(p -> p.getMontant() != null ? p.getMontant() : 0.0)
                .sum();
    }
}
