package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Matiere;

import java.util.List;

public interface MatiereService {

    Matiere addMatiere(Matiere matiere);

    List<Matiere> findAllMatiere();

    Matiere findMatiereById(Long id);
}
