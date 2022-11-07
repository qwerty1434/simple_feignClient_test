package com.example.hobby.service;

import com.example.hobby.client.UserServiceClient;
import com.example.hobby.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService{
    UserServiceClient userServiceClient;

    public HobbyServiceImpl(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Override
    public UserEntity getUserByIdWithFeignClient(Long user_id) {
        UserEntity result = userServiceClient.getUser(user_id);
        return result;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> result = userServiceClient.getAll();
        return result;
    }
}
