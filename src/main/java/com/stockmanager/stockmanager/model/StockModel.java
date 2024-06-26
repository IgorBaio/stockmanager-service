package com.stockmanager.stockmanager.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Document(collection = "Items")
public class StockModel {
    @Id
    String id;
    String product;
    String base;
    Integer quantity;
    String supplier;
    String creationAt;
    String lastUserUsed;

    public StockModel(String product, String base, Integer quantity, String supplier, String lastUserUsed) {
        this.id = product + " - " + base;
        this.product = product;
        this.base = base;
        this.quantity = quantity;
        this.supplier = supplier;
        this.creationAt = LocalDate.now().toString();
        this.lastUserUsed = lastUserUsed;
    }

}
