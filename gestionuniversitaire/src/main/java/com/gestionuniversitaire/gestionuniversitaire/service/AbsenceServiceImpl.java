package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Absence;
import com.gestionuniversitaire.gestionuniversitaire.repository.AbsenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService{
    private AbsenceRepository absenceRepository;
    @Override
    public Absence addAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public List<Absence> findAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence findAbsenceById(Long id) {
        return absenceRepository.findById(id).get();
    }
}
