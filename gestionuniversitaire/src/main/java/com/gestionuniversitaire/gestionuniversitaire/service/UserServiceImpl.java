package com.gestionuniversitaire.gestionuniversitaire.service;

import com.gestionuniversitaire.gestionuniversitaire.exception.UserConflictException;
import com.gestionuniversitaire.gestionuniversitaire.model.Etudiant;
import com.gestionuniversitaire.gestionuniversitaire.model.Professeur;
import com.gestionuniversitaire.gestionuniversitaire.model.Role;
import com.gestionuniversitaire.gestionuniversitaire.model.Users;
import com.gestionuniversitaire.gestionuniversitaire.repository.RoleRepository;
import com.gestionuniversitaire.gestionuniversitaire.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public Users addUser(Users user) {
        if(!isExists(user.getUserName())){
            String pwd = user.getPassword();
            user.setPassword(passwordEncoder.encode(pwd));
            return userRepository.save(user);
        }
        else
            throw new UserConflictException("username "+user.getUserName()+" exist");
    }

    @Override
    public Users findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Professeur addProf(Professeur professeur) {
        if(!isExists(professeur.getUserName())){
            return userRepository.save(professeur);
        }
        else
            throw new UserConflictException("username "+professeur.getUserName()+" exist");
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        if(!isExists(etudiant.getUserName())){
            String pwd = etudiant.getPassword();
            etudiant.setPassword(passwordEncoder.encode(pwd));
            return userRepository.save(etudiant);
        }
        else
            throw new UserConflictException("username "+etudiant.getUserName()+" exist");
    }

    @Override
    public Boolean isExists(String username) {
        if(userRepository.existsByUserName(username)){
            return true;
        }
        else return false;
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUsersById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Users user =userRepository.findByUserName(userName);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
        role.getUsers().add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if (user==null){
            String message = String.format("utilisteur introuvable", username);
            throw new UsernameNotFoundException(message);
        }else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            return new User(user.getUserName(),user.getPassword(),authorities);
        }
    }
}
