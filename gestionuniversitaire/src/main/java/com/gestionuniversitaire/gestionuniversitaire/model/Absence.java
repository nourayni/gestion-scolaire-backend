package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;
    private Date dateAbsence;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Matiere matiere;
}
