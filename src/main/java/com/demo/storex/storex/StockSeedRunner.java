package com.demo.storex.storex;

import java.util.Date;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.repositories.StockRepository;
import com.demo.storex.storex.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockSeedRunner implements CommandLineRunner{

    @Autowired
    StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeStockSeed();
        
    }

    private void initializeStockSeed() {
        if(stockRepository.count() == 0) {
            Stock stock1 = new Stock("Facebook", 5.67, new Date());
            Stock stock2 = new Stock("Eth", 100.45, new Date());
            Stock stock3 = new Stock("DogeCoin", 7.89, new Date());

            stockRepository.save(stock1);
            stockRepository.save(stock2);
            stockRepository.save(stock3);
        }
    }
    
}
