package com.demo.storex.storex;

import java.util.Date;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.services.StockService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockSeedRunner implements CommandLineRunner{

    private final StockService stockService;

    public StockSeedRunner(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeStockSeed();
        
    }

    private void initializeStockSeed() {
        if(stockService.count() == 0) {
            Stock stock1 = new Stock("Facebook", 5.67, new Date());
            Stock stock2 = new Stock("Eth", 100.45, new Date());
            Stock stock3 = new Stock("DogeCoin", 7.89, new Date());

            stockService.createStock(stock1);
            stockService.createStock(stock2);
            stockService.createStock(stock3);
        }
    }
    
}
