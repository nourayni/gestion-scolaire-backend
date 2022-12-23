package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Cohorte;
import com.gestionuniversitaire.gestionuniversitaire.repository.CohorteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
@Transactional
public class CohorteServiceImpl implements CohorteService{

    private CohorteRepository cohorteRepository;
    @Override
    public Cohorte createCohorte(Cohorte cohorte) {
        return cohorteRepository.save(cohorte);
    }

    @Override
    public List<Cohorte> findAllCohorte() {
        return cohorteRepository.findAll();
    }

    @Override
    public Cohorte FindCohorte(Long id) {
        return cohorteRepository.findById(id).get();
    }
}
