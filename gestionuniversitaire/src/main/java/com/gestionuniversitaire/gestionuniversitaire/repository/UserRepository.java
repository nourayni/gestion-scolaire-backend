package com.gestionuniversitaire.gestionuniversitaire.repository;

import com.gestionuniversitaire.gestionuniversitaire.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    Users findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
