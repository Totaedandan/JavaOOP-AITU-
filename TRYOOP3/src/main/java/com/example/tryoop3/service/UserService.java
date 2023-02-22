package com.example.tryoop3.service;
import com.example.tryoop3.entities.Role;
import com.example.tryoop3.entities.User;
import com.example.tryoop3.repositories.RoleRepository;
import com.example.tryoop3.repositories.UserRepository;
import com.example.tryoop3.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//, UserDetailsService
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = getUserByEmail(email);
//        if (Objects.isNull(user)) {
//            throw new UsernameNotFoundException(String.format("User %s is not found", email));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, new HashSet<>());
//    }

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService {

    private  final UserRepository userRepository;

    private  final RoleRepository roleRepository;

    @Override
    public void signUpSave(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

     @Override
     public User saveUser(User user) {
        log.info("Saving new user {} to the  datebase", user.getUsername());
         return userRepository.save(user);
     }

     @Override
     public Role saveRole(Role role) {
         log.info("Saving new role{} to the  datebase" , role.getName());
         return roleRepository.save(role);
     }

     @Override
     public void addRoleToUser(String username, String rolename) {
         log.info("Adding  role{} to user  {} " , rolename  ,username);
         User user  = userRepository.findByUsername(username);
         Role role = roleRepository.findByName(rolename);
         user.getRoles().add(role);
     }

     @Override
     public User getUser(String username) {
         log.info("Fetching user {} "   ,username);
         return userRepository.findByUsername(username);
     }

     @Override
     public List<User> getUsers() {
         log.info("Fetching all users  ");
         return userRepository.findAll();
     }

 }