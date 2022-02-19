package com.demo.storex.storex.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.services.StockService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StockController {
    
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getStocks(@RequestParam(defaultValue = "0") Integer pageNo, 
        @RequestParam(defaultValue = "5") Integer pageSize){
            List<Stock> listOfStocks = stockService.getAllStocks(pageNo, pageSize);
            return new ResponseEntity<>(listOfStocks, HttpStatus.OK);
    }

}
