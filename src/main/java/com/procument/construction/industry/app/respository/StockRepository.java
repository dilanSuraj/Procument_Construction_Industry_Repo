package com.procument.construction.industry.app.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.procument.construction.industry.app.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>{

	Stock findByStockid(Long stockid);
	
    @Transactional
    void deleteByStockid(Long stockid);
}
