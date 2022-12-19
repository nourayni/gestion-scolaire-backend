package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Professeur extends Users {
    private String grade;
    private String matricule;
    private String specialite;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Matiere> matieres= new ArrayList<>();
}
