package com.stockmanager.stockmanager.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.stockmanager.stockmanager.model.StockModel;

@Qualifier("Items")
@Repository
public interface StockRepository extends MongoRepository<StockModel, String> {
    
}
