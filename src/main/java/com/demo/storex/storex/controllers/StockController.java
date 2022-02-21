package com.demo.storex.storex.controllers;

import java.util.List;
import java.util.Optional;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StockController {
    
    @Autowired
    private StockService stockService;

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

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> findStock(@PathVariable("id") Long id) {
        Optional<Stock> foundStock = stockService.findStockById(id);
        if(foundStock.isPresent()){
            return new ResponseEntity<>(foundStock.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable("id") long id, @RequestBody Stock stock) {
        Optional<Stock> stockToUpdate = stockService.findStockById(id);
        if(stockToUpdate.isPresent()) {
            Stock _stock = stockToUpdate.get();
            _stock.setCurrentPrice(stock.getCurrentPrice());
            return new ResponseEntity<>(_stock, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable("id") long id) {
        try {
            stockService.deleteStock(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
