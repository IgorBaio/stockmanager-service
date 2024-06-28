package com.stockmanager.stockmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.stockmanager.dto.UserRequestDTO;
import com.stockmanager.stockmanager.dto.UserResponseDTO;
import com.stockmanager.stockmanager.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/email")
    public UserResponseDTO getUser(@RequestParam String email) {
        return userService.getUser(email);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserRequestDTO dto) throws Exception {
        var savedUser = userService.saveUser(dto);

        return ResponseEntity.ok().body(savedUser);
    }

}
