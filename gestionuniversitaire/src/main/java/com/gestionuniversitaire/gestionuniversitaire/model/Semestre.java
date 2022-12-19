package com.gestionuniversitaire.gestionuniversitaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSemestre;
    private String NumSemestre;
}
