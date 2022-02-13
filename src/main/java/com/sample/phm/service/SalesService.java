package com.sample.phm.service;

import com.sample.phm.entity.Sales;
import com.sample.phm.entity.SalesResponse;
import com.sample.phm.exception.BadSalesCredentialsException;
import com.sample.phm.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    public SalesResponse addSales(Sales sales) throws BadSalesCredentialsException {
        try {
            if(sales.getDate() == null) {
                sales.setDate(LocalDateTime.now());
                salesRepository.save(sales);
            }   else {
                salesRepository.save(sales);
            }
            return new SalesResponse(HttpStatus.ACCEPTED,true,"Sales added succesfully into database");
        } catch (Exception ex) {
            throw new BadSalesCredentialsException("Sales data are incomplete");
        }
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public List<Sales> getSalesByInvoiceId(Integer id) {
        return salesRepository.findAllByInvoice_id(id);
    }
}
