package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.gestionuniversitaire.gestionuniversitaire.model.Role;
import com.gestionuniversitaire.gestionuniversitaire.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleControler {
    private RoleService roleService;

    @PostMapping("/saverole")
    public Role saveRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
}
