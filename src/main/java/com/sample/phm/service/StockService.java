package com.sample.phm.service;

import com.sample.phm.entity.Stock;
import com.sample.phm.exception.StockNotFoundException;
import com.sample.phm.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public Stock getStockByMedId(Integer id) throws StockNotFoundException {
        Optional<Stock> stock = stockRepository.findById(id);

        if(stock.isPresent()) {
            return stock.get();
        } else {
            throw new StockNotFoundException("Stock not present in database");
        }
    }

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }
}
