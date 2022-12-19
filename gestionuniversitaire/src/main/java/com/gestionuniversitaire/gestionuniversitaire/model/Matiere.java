package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatiere;
    private int coef;
    private int credit;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "matiere")
    private Collection<Note> note ;
    @OneToMany(mappedBy = "matiere",fetch = FetchType.LAZY)
    private Collection<Absence> absences;
    @ManyToMany(mappedBy = "matieres",fetch = FetchType.EAGER)
    private Collection<Professeur> professeurs= new ArrayList<>();
}
