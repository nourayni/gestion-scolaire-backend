package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNote;
    private int noteControle;
    private int noteExamen;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Matiere matiere;
}
