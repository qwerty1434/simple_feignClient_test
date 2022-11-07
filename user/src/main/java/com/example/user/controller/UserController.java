package com.example.user.controller;

import com.example.user.entity.UserEntity;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/findAll")
    public List<UserEntity> findAll(){
        return userService.findall();
    }

    @GetMapping("/findUser/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody String username){
        System.out.println("username = " + username);
        userService.createUser(username);
    }

}
