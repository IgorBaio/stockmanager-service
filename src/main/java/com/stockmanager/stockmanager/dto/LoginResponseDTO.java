package com.stockmanager.stockmanager.dto;

public record LoginResponseDTO(
    String accessToken,
    Long expiresIn
) {
    
}
