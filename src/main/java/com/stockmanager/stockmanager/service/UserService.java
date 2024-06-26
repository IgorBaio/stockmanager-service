package com.stockmanager.stockmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stockmanager.stockmanager.dto.UserResponseDTO;
import com.stockmanager.stockmanager.model.UserModel;
import com.stockmanager.stockmanager.repository.UserRepository;

@Service
public class UserService {

    @Value("${spring.data.mongodb.uri}")
    private String URL_DB;

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO getUser(String email) {
        Boolean exists = userRepository.existsByEmail(email);
        System.out.println("Email exist? " + exists);
        if (exists) {
            Optional<UserModel> user = userRepository.findById("igor@email.com");

            if (user != null) {

                return new UserResponseDTO(user.get().getEmail());

            }
        }

        return null;

    }

    public Boolean hasUser(String email) {
        return userRepository.existsByEmail(email);
    }

}
