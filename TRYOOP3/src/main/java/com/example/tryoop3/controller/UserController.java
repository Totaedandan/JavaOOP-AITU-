package com.example.tryoop3.controller;

import com.example.tryoop3.entities.Role;
import com.example.tryoop3.entities.User;
import com.example.tryoop3.service.interfaces.IUserService;
import jakarta.xml.ws.Service;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(iUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toString());
        return ResponseEntity.created(uri).body(iUserService.saveUser(user));
    }

    @PostMapping("/user/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toString());
        return ResponseEntity.created(uri).body(iUserService.saveRole(role));
    }

    @PostMapping("/user/addtoUser")
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form) {
        iUserService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }


    @GetMapping("/login")
    public ModelAndView redirectToLogin(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("index1", model);
    }

    @PostMapping("/login")
    public ModelAndView LoginConnect(@RequestParam("email") String email,
                                     @RequestParam("password") String password, ModelMap modelMap) {
        User user = iUserService.getUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("index1", modelMap);
    }

    @GetMapping("/signup")
    public ModelAndView redirectToSignup(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("index1", model);
    }

    @PostMapping("/signup")
    public ModelAndView handleFormSubmit(@RequestParam("username") String username,
                                         @RequestParam("surname") String surname,
                                         @RequestParam("email") String email,
                                         @RequestParam("password") String password, ModelMap model) {
        User user = new User( username, surname, email, password);
        iUserService.signUpSave(user);
        return redirectToLogin(model);
    }

    @PostMapping("/createAdam")
    public ResponseEntity<User> createAdam(@RequestBody User user) {
        User saved = iUserService.createUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = iUserService.getUserByEmail(email);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable int id) {
        iUserService.deleteUserById(id);
        ;
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
@Data
class RoleToUserForm{
    private String  username;
    private String rolename;
}