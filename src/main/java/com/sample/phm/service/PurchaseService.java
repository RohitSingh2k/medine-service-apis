package com.sample.phm.service;

import com.sample.phm.entity.DeleteResponse;
import com.sample.phm.entity.Purchase;
import com.sample.phm.exception.PurchaseNotFoundException;
import com.sample.phm.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public Integer addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
        return purchase.getId();
    }

    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    public DeleteResponse deletePurchaseById(Integer id) throws PurchaseNotFoundException {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        if(purchase.isPresent()) {
            purchaseRepository.delete(purchase.get());
            return new DeleteResponse(HttpStatus.FOUND,true, "Purchase deleted succesfully");
        } else {
            throw new PurchaseNotFoundException("Purchase is not in database");
        }
    }

    public Purchase getPurchaseById(Integer id) throws PurchaseNotFoundException {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        if(purchase.isPresent()) {
            return purchase.get();
        } else {
            throw new PurchaseNotFoundException("Purchase not found in database");
        }
    }
}
