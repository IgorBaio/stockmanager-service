package com.stockmanager.stockmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.stockmanager.dto.StockRequestDTO;
import com.stockmanager.stockmanager.model.StockModel;
import com.stockmanager.stockmanager.model.UserModel;
import com.stockmanager.stockmanager.repository.StockRepository;
import com.stockmanager.stockmanager.repository.UserRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;


    public StockModel save(String emailUser, StockRequestDTO stockRequestDTO) {
        try {
            
            StockModel stockModel = new StockModel(
                    stockRequestDTO.product(),
                    stockRequestDTO.base(),
                    stockRequestDTO.quantity(),
                    stockRequestDTO.supplier(),
                    emailUser);
            stockRepository.save(stockModel);

            return stockModel;

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
