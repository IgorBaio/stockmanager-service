package com.stockmanager.stockmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.stockmanager.stockmanager.dto.LoginRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Users")
public class UserModel {
    
    @Id
    private String email;
    private String name;
    private String password;
    private String accessLvl;

    public Boolean isLoginCorrect(LoginRequestDTO requestDTO, PasswordEncoder encoder){
        return encoder.matches(requestDTO.password(), this.password);
    }

}
