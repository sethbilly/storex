package com.demo.storex.storex.repositories;

import com.demo.storex.storex.models.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock, Long>{
}
