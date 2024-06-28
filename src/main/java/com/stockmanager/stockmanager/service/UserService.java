package com.stockmanager.stockmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockmanager.stockmanager.dto.UserRequestDTO;
import com.stockmanager.stockmanager.dto.UserResponseDTO;
import com.stockmanager.stockmanager.model.UserModel;
import com.stockmanager.stockmanager.repository.UserRepository;

@Service
public class UserService {

    // @Value("${spring.data.mongodb.uri}")
    // private String URL_DB;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO getUser(String email) {
        Boolean exists = userRepository.existsByEmail(email);
        System.out.println("Email exist? " + exists);
        if (exists) {
            Optional<UserModel> user = userRepository.findById(email);

            if (user != null) {

                return new UserResponseDTO(user.get().getEmail(), user.get().getAccessLvl());

            }
        }

        return null;

    }

    public UserResponseDTO saveUser(UserRequestDTO dto) throws Exception {

        var entity = new UserModel(
                dto.email(),
                dto.name(),
                passwordEncoder.encode(dto.password()),
                dto.accessLvl());

        if (userRepository.existsByEmail(entity.getEmail())) {
            throw new Exception("User already exists");
        }

        UserResponseDTO userResponseDTO;
        try {
            userRepository.save(entity);
            userResponseDTO = new UserResponseDTO(entity.getEmail(), entity.getAccessLvl());
        } catch (Exception e) {
            userResponseDTO = null;
        }

        return userResponseDTO;
    }

    public Boolean hasUser(String email) {
        return userRepository.existsByEmail(email);
    }

}
