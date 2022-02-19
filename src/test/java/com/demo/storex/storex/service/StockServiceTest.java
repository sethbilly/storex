package com.demo.storex.storex.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.repositories.StockRepository;
import com.demo.storex.storex.services.StockService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    
    @InjectMocks
    StockService stockService;

    @Mock
    StockRepository stockRepository;

    @Test
    public void testCreateStock() {
        Stock stock = new Stock("MTN", 1.50, new Date());
        stockService.createStock(stock);

        verify(stockRepository, times(1)).save(stock);
    }
}
