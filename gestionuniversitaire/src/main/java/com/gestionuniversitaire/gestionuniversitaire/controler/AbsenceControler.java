package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.gestionuniversitaire.gestionuniversitaire.model.Absence;
import com.gestionuniversitaire.gestionuniversitaire.service.AbsenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AbsenceControler {
    private AbsenceService absenceService;
    @PostMapping("/addabsence")
    public Absence addAbsence(@RequestBody Absence absence){
        return absenceService.addAbsence(absence);
    }
    @GetMapping("/findabsence")
    public List<Absence> getAbsences(){
        return absenceService.findAllAbsences();
    }
}
