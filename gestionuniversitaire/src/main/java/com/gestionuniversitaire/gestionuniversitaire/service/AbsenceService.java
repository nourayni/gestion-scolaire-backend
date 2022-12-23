package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Absence;

import java.util.List;

public interface AbsenceService {
    Absence addAbsence(Absence absence);
    List<Absence> findAllAbsences();

    Absence findAbsenceById(Long id);
}
