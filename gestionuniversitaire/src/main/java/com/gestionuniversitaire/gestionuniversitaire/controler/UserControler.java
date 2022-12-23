package com.gestionuniversitaire.gestionuniversitaire.controler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionuniversitaire.gestionuniversitaire.model.Etudiant;
import com.gestionuniversitaire.gestionuniversitaire.model.Professeur;
import com.gestionuniversitaire.gestionuniversitaire.model.Users;
import com.gestionuniversitaire.gestionuniversitaire.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
@RestController
@AllArgsConstructor
public class UserControler {
    private static final String secret= "tdsisecretkey";
    private UserService userService;
    @PostMapping("/saveuser")
    public Users save(@RequestBody Users users){
        Users result = userService.addUser(users);
        return result;
    }
    @PostMapping("/saveprof")
    public Professeur saveProf(@RequestBody Professeur prof){
        Professeur professeur = userService.addProf(prof);
        return professeur;
    }
    @PostMapping("/saveetudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudi){
        Etudiant etudiant = userService.addEtudiant(etudi);
        return etudiant;
    }

    @GetMapping("/users")
    public List<Users> listerUsers(){
        return  userService.findAllUsers();
    }
    @GetMapping("/user/{id}")
    public Users findUserById(@PathVariable String id){
        return userService.getUsersById(id);
    }
    @PostMapping("/addroletouser")
    public void addroleToUser(@RequestBody UserRole userRole){
        userService.addRoleToUser(userRole.getUser(),userRole.getRole());
    }
    @GetMapping("/findetudiant")
    public List<Users> findetudiant(){
        return userService.findAllEtudiant();
    }

    @GetMapping("findprof")
    public  List<Users> finprof(){
        return userService.findAllProf();
    }

    // refresh token
    @GetMapping("/refreshtoken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String authToken = request.getHeader("Authorization");
        if (authToken!=null && authToken.startsWith("Bearer ")){

            try{
                String jwt =authToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256(secret);
                JWTVerifier jwtVerifier= JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String userName = decodedJWT.getSubject();
                Users user = userService.findUserByUserName(userName);

                String jwtAccesToken = JWT.create()
                        .withSubject(user.getUserName())
                        .withExpiresAt(Date.from(Instant.now().plusSeconds(24*3600)))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",user.getRoles().stream().map(role->role.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String,String> idToken = new HashMap<>();
                idToken.put("access-token",jwtAccesToken);
                idToken.put("refresh-token",jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),idToken);

            }catch (Exception e){
                throw  e;
            }

        }
        else {
            throw new RuntimeException("mauvais token");
        }
    }
}
@Data
class UserRole{
    private String user;
    private String role;
}
