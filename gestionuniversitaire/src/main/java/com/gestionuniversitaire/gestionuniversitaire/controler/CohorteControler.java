package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.gestionuniversitaire.gestionuniversitaire.model.Cohorte;
import com.gestionuniversitaire.gestionuniversitaire.service.CohorteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CohorteControler {
    private CohorteService cohorteService;
    @PostMapping("/savecohorte")
    public Cohorte saveCohorte(@RequestBody Cohorte cohorte){
        return cohorteService.createCohorte(cohorte);
    }
    @GetMapping("/getcohorte")
    public List<Cohorte> getCohorte(){
        return cohorteService.findAllCohorte();
    }
    @GetMapping("/cohortebyid/{idCohorte}")
    public Cohorte findCohorteById(@PathVariable Long idCohorte){
        return cohorteService.FindCohorte(idCohorte);
    }
}
