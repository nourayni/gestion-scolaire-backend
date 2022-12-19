package com.gestionuniversitaire.gestionuniversitaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    private String userName;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String lieuDeNaissance;
    private double numtelephone;
    private String password;
    private String profession;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "users")
    private Collection<Role> roles = new ArrayList<>();

}
