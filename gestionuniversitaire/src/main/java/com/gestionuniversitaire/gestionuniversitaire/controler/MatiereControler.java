package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.gestionuniversitaire.gestionuniversitaire.model.Matiere;
import com.gestionuniversitaire.gestionuniversitaire.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatiereControler {

    private MatiereService matiereService;
    @PostMapping("/addmatiere")
    public Matiere addMatiere(@RequestBody Matiere matiere){
        return matiereService.addMatiere(matiere);
    }
    @GetMapping("/allMatiere")
    public List<Matiere> findAllMatiere(){
        return matiereService.findAllMatiere();
    }
}
