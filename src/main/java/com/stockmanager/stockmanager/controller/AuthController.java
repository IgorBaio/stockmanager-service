package com.stockmanager.stockmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.stockmanager.dto.LoginRequestDTO;
import com.stockmanager.stockmanager.dto.LoginResponseDTO;
import com.stockmanager.stockmanager.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login (@RequestBody LoginRequestDTO requestDTO){
        return new ResponseEntity<>(authService.authUser(requestDTO), HttpStatus.OK);
    }
}
