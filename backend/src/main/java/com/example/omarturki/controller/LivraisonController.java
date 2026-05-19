package com.example.omarturki.controller;

import com.example.omarturki.model.Livraison;
import com.example.omarturki.service.LivraisonService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {
    private final LivraisonService livraisonService;

    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @GetMapping
    public List<Livraison> getAllLivraisons() {
        return livraisonService.getAllLivraisons();
    }

    @GetMapping("/{id}")
    public Livraison getLivraison(@PathVariable Long id) {
        return livraisonService.getLivraisonById(id);
    }

    @PostMapping
    public Livraison createLivraison(@RequestBody Livraison livraison) {
        return livraisonService.saveLivraison(livraison);
    }

    @PutMapping("/{id}")
    public Livraison updateLivraison(@PathVariable Long id, @RequestBody Livraison livraison) {
        return livraisonService.updateLivraison(id, livraison);
    }
}
