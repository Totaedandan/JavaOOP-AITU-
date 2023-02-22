package com.example.tryoop3;

import com.example.tryoop3.entities.Role;
import com.example.tryoop3.entities.User;
import com.example.tryoop3.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Tryoop3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tryoop3Application.class, args);
    }

    @Bean
    CommandLineRunner run (UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta" , "travolta", "111@123"  , "111" ,new ArrayList<>()));
            userService.saveUser(new User(null, "Tolebi  Baitasov" , "baitasov", "111@124"  , "111", new ArrayList<>()));
            userService.saveUser(new User(null, "S@ken Oralkhan" , "s@ken", "111@125"  , "111", new ArrayList<>()));
            userService.saveUser(new User(null, "Meyrambek Yaki" , "yaki", "111@126"  , "111", new ArrayList<>()));


            userService.addRoleToUser("travolta" , "ROLE_USER");
            userService.addRoleToUser("baitasov" , "ROLE_MANAGER");
            userService.addRoleToUser("s@ken" , "ROLE_ADMIN");
            userService.addRoleToUser("yaki" , "ROLE_SUPER_ADMIN");

        };
    }
}
