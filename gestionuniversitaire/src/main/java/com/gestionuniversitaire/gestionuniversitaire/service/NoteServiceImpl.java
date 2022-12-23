package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Note;
import com.gestionuniversitaire.gestionuniversitaire.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
    private NoteRepository noteRepository;
    @Override
    public List<Note> findAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note findNoteById(Long id) {
        return noteRepository.findById(id).get();
    }
}
