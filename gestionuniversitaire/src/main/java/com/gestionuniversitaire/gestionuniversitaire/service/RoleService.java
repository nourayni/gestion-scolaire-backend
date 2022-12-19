package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface RoleService {
    Role addRole(Role role);
}
