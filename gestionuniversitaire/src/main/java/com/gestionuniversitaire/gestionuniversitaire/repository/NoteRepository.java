package com.gestionuniversitaire.gestionuniversitaire.repository;

import com.gestionuniversitaire.gestionuniversitaire.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {

}
