package com.example.hobby.controller;

import com.example.hobby.entity.UserEntity;
import com.example.hobby.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HobbyController {
    HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAll(){
        List<UserEntity> result = hobbyService.findAll();
        return result;
    }

    @GetMapping("/getUser/{user_id}")
    public String getUser(@PathVariable Long user_id){
        UserEntity result = hobbyService.getUserByIdWithFeignClient(user_id);
        System.out.println("result = " + result);
        return result.toString();
    }
}
