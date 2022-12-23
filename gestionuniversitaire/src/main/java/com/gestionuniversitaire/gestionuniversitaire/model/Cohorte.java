package com.gestionuniversitaire.gestionuniversitaire.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Cohorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCohorte;
    private String nomCohorte;
    private Date anneeUniversotaire;
    @OneToMany(mappedBy = "cohorte",fetch = FetchType.LAZY)
    private Collection<Etudiant> etudiants;
    @ManyToOne
    private Departement departement;

}
