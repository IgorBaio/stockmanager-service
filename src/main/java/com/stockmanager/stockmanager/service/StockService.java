package com.stockmanager.stockmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.stockmanager.dto.StockRequestDTO;
import com.stockmanager.stockmanager.model.StockModel;
import com.stockmanager.stockmanager.model.UserModel;
import com.stockmanager.stockmanager.repository.StockRepository;
import com.stockmanager.stockmanager.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<StockModel> get (String emailUser, String base){
        try{

            List<StockModel> productsResponse = new ArrayList<>();

            var listProducts = stockRepository.findByBase(base);

            for (StockModel listProduct : listProducts) {
            productsResponse.add(new StockModel(
                    listProduct.getProduct(),
                    listProduct.getBase(),
                    listProduct.getQuantity(),
                    listProduct.getSupplier(),
                    emailUser

            ));

            }

            return productsResponse;

        }catch (Exception e){

        }
        return List.of();
    }

    public List<StockModel> save(String emailUser, List<StockRequestDTO> stockRequestDTO) {
        try {

            List<StockModel> stockSaved = new ArrayList<>();
            for (StockRequestDTO stockModel: stockRequestDTO  ){
                 var stokcForSave = new StockModel(
                         stockModel.product(),
                         stockModel.base(),
                         stockModel.quantity(),
                         stockModel.supplier(),
                        emailUser);

                 stockSaved.add(stokcForSave);
            }
            

            stockRepository.saveAll(stockSaved);

            return stockSaved;

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
