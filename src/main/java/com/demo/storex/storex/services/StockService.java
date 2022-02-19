package com.demo.storex.storex.services;

import java.util.Optional;
import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.repositories.StockRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class StockService {
    
    
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Stock createStock(Stock stock) {
       return  stockRepository.save(stock);
    }

    public Page<Stock> getAllStocks(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }

    public Optional<Stock> findStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock updateStock(Stock stockToUpdate) {
        return stockRepository.save(stockToUpdate);
    }

    public void deleteStock(Stock stockToDelete) {
        stockRepository.delete(stockToDelete);
    }

}
