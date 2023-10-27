package com.devrezaur.user.service.service;

import com.devrezaur.user.service.model.User;
import com.devrezaur.user.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
