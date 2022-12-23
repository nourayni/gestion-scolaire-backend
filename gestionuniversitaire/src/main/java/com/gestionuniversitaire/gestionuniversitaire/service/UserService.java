package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.model.Etudiant;
import com.gestionuniversitaire.gestionuniversitaire.model.Professeur;
import com.gestionuniversitaire.gestionuniversitaire.model.Users;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Users addUser(Users user);
    Users findUserByUserName(String userName);
    Professeur addProf(Professeur professeur);
    Etudiant addEtudiant(Etudiant etudiant);
    Boolean isExists(String username);

    List<Users> findAllUsers();

    Users getUsersById(String id);

    void addRoleToUser(String userName,String roleName);

    List<Users> findAllEtudiant();

    List<Users> findAllProf();
}
