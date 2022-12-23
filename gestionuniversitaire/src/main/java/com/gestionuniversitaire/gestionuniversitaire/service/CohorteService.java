package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Cohorte;

import java.util.List;

public interface CohorteService {
    Cohorte createCohorte(Cohorte cohorte);

    List<Cohorte> findAllCohorte();

    Cohorte FindCohorte(Long id);

}
