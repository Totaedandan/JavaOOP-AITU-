package com.example.tryoop3.service.interfaces;

import com.example.tryoop3.entities.Role;
import com.example.tryoop3.entities.User;

import java.util.List;


public interface IUserService {

    void signUpSave(User user);

    User getUserByEmail (String email);

    void deleteUserById(int id);

    User createUser (User user);

    User saveUser(User user);
    Role saveRole (Role role);
    void addRoleToUser(String username , String rolename);
    User getUser(String username);
    List<User> getUsers ();
}
