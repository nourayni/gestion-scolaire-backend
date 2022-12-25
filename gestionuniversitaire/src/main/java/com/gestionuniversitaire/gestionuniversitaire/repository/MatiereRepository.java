package com.gestionuniversitaire.gestionuniversitaire.repository;

import com.gestionuniversitaire.gestionuniversitaire.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere,Long> {
    Matiere findByIdMatiere(Long idMatiere);
}
