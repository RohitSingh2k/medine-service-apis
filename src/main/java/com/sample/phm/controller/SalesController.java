package com.sample.phm.controller;

import com.sample.phm.entity.Sales;
import com.sample.phm.entity.SalesResponse;
import com.sample.phm.exception.BadSalesCredentialsException;
import com.sample.phm.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SalesController {

    @Autowired
    SalesService salesService;

    @GetMapping("/sales")
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping("/sales")
    public SalesResponse addSale(@RequestBody Sales sales) throws BadSalesCredentialsException {
        return salesService.addSales(sales);
    }
}
