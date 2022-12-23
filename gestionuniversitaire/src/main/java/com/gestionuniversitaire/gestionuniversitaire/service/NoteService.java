package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAllNote();
    Note addNote(Note note);
    Note findNoteById(Long id);
}
