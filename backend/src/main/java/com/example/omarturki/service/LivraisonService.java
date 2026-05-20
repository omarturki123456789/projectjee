package com.example.omarturki.service;

import com.example.omarturki.model.Livraison;
import com.example.omarturki.model.LivraisonStatus;
import com.example.omarturki.reposority.LivraisonRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivraisonService {
    private final LivraisonRepository livraisonRepository;

    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    public Livraison getLivraisonById(Long id) {
        return livraisonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison not found: " + id));
    }

    public Livraison saveLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    public Livraison updateLivraison(Long id, Livraison livraison) {
        Livraison existing = getLivraisonById(id);
        existing.setCommande(livraison.getCommande());
        existing.setTransporteur(livraison.getTransporteur());
        existing.setDateLivraison(livraison.getDateLivraison());
        existing.setCout(livraison.getCout());
        existing.setStatut(livraison.getStatut());
        return livraisonRepository.save(existing);
    }

    public long countPending() {
        return livraisonRepository.countByStatut(LivraisonStatus.EN_ATTENTE)
             + livraisonRepository.countByStatut(LivraisonStatus.EN_COURS);
    }
}
