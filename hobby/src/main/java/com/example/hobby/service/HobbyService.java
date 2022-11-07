package com.example.hobby.service;

import com.example.hobby.entity.UserEntity;

import java.util.List;

public interface HobbyService {
    UserEntity getUserByIdWithFeignClient(Long user_id);
    List<UserEntity> findAll();
}
