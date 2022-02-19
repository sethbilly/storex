package com.demo.storex.storex.repositories;

import java.util.List;

import com.demo.storex.storex.models.Stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock, Long>{
    
    Page<Stock> findAll(Pageable pageable);
}
