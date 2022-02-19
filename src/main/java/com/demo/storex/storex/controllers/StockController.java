package com.demo.storex.storex.controllers;

import com.demo.storex.storex.services.StockService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StockController {
    
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    


}
