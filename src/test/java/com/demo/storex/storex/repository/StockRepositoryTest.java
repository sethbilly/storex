package com.demo.storex.storex.repository;

import java.util.Date;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.repositories.StockRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StockRepositoryTest {
    
    @Autowired
    StockRepository stockRepository;

    @Test
    public void testCreateReadDeleteStock() {
        Stock stock = new Stock("MTN", 1.50, new Date());
        stockRepository.save(stock);
 
        Iterable<Stock> stocks = stockRepository.findAll();
        Assertions.assertThat(stocks).extracting(Stock::getName).containsOnly("MTN");
 
        stockRepository.deleteAll();
        Assertions.assertThat(stockRepository.findAll()).isEmpty();
    }

}
