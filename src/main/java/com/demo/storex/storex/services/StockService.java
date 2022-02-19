package com.demo.storex.storex.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import com.demo.storex.storex.models.Stock;
import com.demo.storex.storex.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StockService {
    
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Stock createStock(Stock stock) {
       return  stockRepository.save(stock);
    }

    public List<Stock> getAllStocks(int pageNo, int pageSize) {
       Pageable pageable = PageRequest.of(pageNo, pageSize);
       Page<Stock> pagedResult = stockRepository.findAll(pageable);
       if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public Optional<Stock> findStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Transactional
    public Stock updateStock(Stock stockToUpdate) {
        return stockRepository.save(stockToUpdate);
    }

    public void deleteStock(Stock stockToDelete) {
        stockRepository.delete(stockToDelete);
    }

    public long count() {
        return stockRepository.count();
    }

}
