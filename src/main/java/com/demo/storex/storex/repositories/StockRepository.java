package com.demo.storex.storex.repositories;

import com.demo.storex.storex.models.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long>{
    
}
