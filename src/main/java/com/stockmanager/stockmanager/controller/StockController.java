package com.stockmanager.stockmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.stockmanager.dto.StockRequestDTO;
import com.stockmanager.stockmanager.model.StockModel;
import com.stockmanager.stockmanager.service.StockService;
import com.stockmanager.stockmanager.service.UserService;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    @PutMapping("/save")
    public String save(@RequestParam String email, @RequestBody List<StockRequestDTO> stockRequestDTO) {

        Boolean hasUser = userService.hasUser(email);
        if (hasUser) {
            var itemsSaved = stockService.save(email, stockRequestDTO);

            if (itemsSaved != null) {
                return "item salvo";
            }

            return "Houve um erro";
        }

        return "Usuário não encontrado";
    }

    @GetMapping
    public List<StockModel> getProducts(@RequestParam String email, @RequestParam String base){
        Boolean hasUser = userService.hasUser(email);
        if (hasUser) {
            var itemsSaved = stockService.get(email, base);

            if (itemsSaved != null) {
                return itemsSaved;
            }

            return List.of();
        }
        return null;
    }





}
