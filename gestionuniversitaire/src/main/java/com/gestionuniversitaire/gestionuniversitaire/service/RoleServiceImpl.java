package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Role;
import com.gestionuniversitaire.gestionuniversitaire.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;
    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}
