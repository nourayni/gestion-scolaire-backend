package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartement;
    private String NomDepartemnet;
    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY)
    private Collection<Cohorte> cohortes;
}
