package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.gestionuniversitaire.gestionuniversitaire.model.Note;
import com.gestionuniversitaire.gestionuniversitaire.repository.NoteRepository;
import com.gestionuniversitaire.gestionuniversitaire.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class NoteControler {
    private NoteService noteService;
    private final NoteRepository noteRepository;

    @PostMapping("/addnote")
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }
    @GetMapping("/findallnote")
    public List<Note> findNote(){
        return noteService.findAllNote();
    }
    @GetMapping("/findnote")
    public Note findNote(@PathVariable Long idNote){
        return noteService.findNoteById(idNote);
    }
}
