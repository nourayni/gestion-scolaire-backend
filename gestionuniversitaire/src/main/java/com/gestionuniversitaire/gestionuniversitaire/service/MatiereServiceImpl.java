package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Matiere;
import com.gestionuniversitaire.gestionuniversitaire.repository.MatiereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
@Transactional
public class MatiereServiceImpl implements MatiereService{
    private MatiereRepository matiereRepository;
    @Override
    public Matiere addMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public List<Matiere> findAllMatiere() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere findMatiereById(Long id) {
        return matiereRepository.findById(id).get();
    }
}
