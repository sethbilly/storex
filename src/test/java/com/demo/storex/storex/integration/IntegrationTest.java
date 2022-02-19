package com.demo.storex.storex.integration;

import java.util.Date;
import java.util.List;

import com.demo.storex.storex.controllers.StockController;
import com.demo.storex.storex.models.Stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTest {
    
    @Autowired
    StockController stockController;

    @Test
    public void testCreateReadDelete() {
        Stock stock = new Stock("MTN", 1.50, new Date());
 
        ResponseEntity<Stock> stockResult = stockController.addStock(stock);
        Assertions.assertThat(stockResult.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    
        ResponseEntity<List<Stock>> employees = stockController.getStocks(null, null);
        Assertions.assertThat(employees.getStatusCode()).isEqualTo(HttpStatus.OK);
    
        ResponseEntity<HttpStatus> deletedStock = stockController.deleteStock(stock.getId());
        Assertions.assertThat(deletedStock.getBody()).isNull();
    }
}
