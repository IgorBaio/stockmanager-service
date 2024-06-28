package com.stockmanager.stockmanager.service;

import java.time.Instant;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.stockmanager.stockmanager.dto.LoginRequestDTO;
import com.stockmanager.stockmanager.dto.LoginResponseDTO;
import com.stockmanager.stockmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
    private static final Long EXPIRES_IN = 30000000L;

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginResponseDTO authUser(LoginRequestDTO loginRequestDTO){
        var user = userRepository.findById(loginRequestDTO.email());

        if (user == null || !user.get().isLoginCorrect(loginRequestDTO, passwordEncoder)){
           throw new BadCredentialsException("User or password is invalid!");
       }

        var claims = JwtClaimsSet.builder()
            .issuer("stock.manager.backend")
            .subject(user.get().getEmail())
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plusSeconds(EXPIRES_IN))
            .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(jwtValue, EXPIRES_IN);
    }

}
