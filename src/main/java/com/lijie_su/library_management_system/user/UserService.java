package com.lijie_su.library_management_system.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public void addNewUser(User user){
        Optional<User> u=userRepository.findUserByEmail(user.getUser_email());
        if(u.isPresent()){
            throw new IllegalStateException("Email is exist");
        }
        userRepository.save(user);
    }

}
