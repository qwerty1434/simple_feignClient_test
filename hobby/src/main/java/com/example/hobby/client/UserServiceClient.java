package com.example.hobby.client;

import com.example.hobby.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="user-service")
public interface UserServiceClient {
    @GetMapping("/findUser/{userId}")
    UserEntity getUser(@PathVariable Long userId);

    @GetMapping("/findAll")
    List<UserEntity> getAll();

}
