package com.demo.storex.storex.controllers;

import java.util.List;
import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class StockController {
    
    @Autowired
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

    @PostMapping("/stocks")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        try {
            Stock savedStock = stockService.createStock(stock);
            if(null == savedStock) {
                return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
            }else  {
                return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
