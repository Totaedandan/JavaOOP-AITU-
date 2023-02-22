package com.example.tryoop3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String surname;
    private String email;
    private String password;

    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Role> roles =  new ArrayList<>();
    public User(String username, String surname, String email, String password) {
        setEmail(email);
        setUsername(username);
        setSurname(surname);
        setPassword(password);
    }
    public User(Integer id,   String surname, String username,String email, String password, ArrayList<Role> roles) {
        setId(id);
        setEmail(email);
        setUsername(username);
        setSurname(surname);
        setPassword(password);
        setRoles(roles);
    }

}