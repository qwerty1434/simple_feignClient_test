package com.example.user.service;

import com.example.user.entity.UserEntity;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserById(Long user_id) {
        UserEntity result = userRepository.findById(user_id).orElseThrow();
        return result;
    }

    @Override
    public void createUser(String username) {
        UserEntity userEntity = UserEntity.builder().user_name(username).build();
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findall() {
        return userRepository.findAll();
    }
}
