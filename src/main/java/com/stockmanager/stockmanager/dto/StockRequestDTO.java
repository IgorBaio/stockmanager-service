package com.stockmanager.stockmanager.dto;

public record  StockRequestDTO(
    String product,
    String base,
    Integer quantity,
    String supplier,
    String creationAt,
    String lastUserUsed
) {
    
}
