package com.example.user.service;

import com.example.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getUserById(Long user_Id);
    void createUser(String username);

    List<UserEntity> findall();
}
