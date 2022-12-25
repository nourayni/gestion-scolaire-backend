package com.gestionuniversitaire.gestionuniversitaire.repository;

import com.gestionuniversitaire.gestionuniversitaire.model.Professeur;
import com.gestionuniversitaire.gestionuniversitaire.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,String> {
    Users findByUserName(String userName);

    Boolean existsByUserName(String userName);
    @Query("select u from Users u where u.profession='etudiant'")
    List<Users> findAllEtudiant();

    @Query("select p from Users p where p.profession='professeur'")
    List<Users> findAllProf();
}
