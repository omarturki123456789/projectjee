package com.example.omarturki.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "transporteurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transporteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String telephone;
    private String note;

    @JsonIgnore
    @OneToMany(mappedBy = "transporteur")
    private List<Livraison> livraisons;
}
