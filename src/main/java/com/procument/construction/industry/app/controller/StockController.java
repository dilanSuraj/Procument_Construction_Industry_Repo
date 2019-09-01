package com.procument.construction.industry.app.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.procument.construction.industry.app.entity.Stock;
import com.procument.construction.industry.app.respository.StockRepository;

@RequestMapping(value = "/stocks")
@Controller
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	private static final String OBJECT_NOT_FOUND = "404 Object not found";
	private static final String REORDER_LEVEL_ERROR = "Order unsuccesfull due to cannot order more than re-order level";

	public static final Logger log = Logger.getLogger(SiteController.class.getName());

	@PostMapping("/")
	public String addStock(@ModelAttribute(value = "stockObj") Stock stock) {
		stockRepository.save(stock);
		log.info(stock.toString() + "\n");
		return stock.toString();
	}

	@GetMapping("/")
	public List<Stock> findAllStocks() {
		List<Stock> stockList = (List<Stock>) stockRepository.findAll();
		log.info(stockList.toString() + "\n");
		return stockList;
	}
	
	@GetMapping("/{siteid}")
	public Stock findByStockId(@RequestParam Long stockid) {
		Stock stock = stockRepository.findByStockid(stockid);
        log.info(stock.toString() + "\n");
        return stock;
    }
	
	@PutMapping("/")
	public String updateStock(@ModelAttribute(value = "stockObj") Stock stock) {
		
		Stock existingStockObj = stockRepository.findByStockid(stock.getStockid());
		
		if(existingStockObj != null) {
			if(stock.getQuantity() <= existingStockObj.getReorderlevel()) {
				log.info(REORDER_LEVEL_ERROR+ "\n");
				return REORDER_LEVEL_ERROR;
			}
			existingStockObj.setQuantity(stock.getQuantity());
			existingStockObj.setName(stock.getName());
			stockRepository.save(existingStockObj);
			
			log.info(existingStockObj.toString() + "\n");
			return existingStockObj.toString();
		}
		log.info(OBJECT_NOT_FOUND + "\n");
		return OBJECT_NOT_FOUND;
	}
	
	@DeleteMapping("/{siteid}")
	public String deleteStock(@RequestParam Long stockid) {
		
		Stock existingStockObj = stockRepository.findByStockid(stockid);
		
		if(existingStockObj != null) {
			stockRepository.deleteByStockid(stockid);
			log.info(existingStockObj.toString() + "\n");
			return existingStockObj.toString();
		}
		log.info(OBJECT_NOT_FOUND + "\n");
		return OBJECT_NOT_FOUND;
	}

}
