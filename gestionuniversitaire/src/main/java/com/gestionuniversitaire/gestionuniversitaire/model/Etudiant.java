package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Etudiant extends Users {
    private String numeroCarte;
    private String filiere;
    private String anneeUniversitaire;
    private String niveau;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "etudiant")
    private Collection<Note> note ;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private Collection<Absence> absences;
    @ManyToOne
    private Cohorte cohorte;

}
