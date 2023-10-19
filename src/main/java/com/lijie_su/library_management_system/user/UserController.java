package com.lijie_su.library_management_system.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser(); 
    }
    @GetMapping(path="api/v1/user/{user_id}")
    public User getUserById(@PathVariable Long user_id){
        return userService.getUserById(user_id);
    }
}
