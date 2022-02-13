package com.sample.phm.controller;

import com.sample.phm.entity.Purchase;
import com.sample.phm.entity.PurchaseDetailsResponse;
import com.sample.phm.entity.PurchaseRequest;
import com.sample.phm.entity.PurchaseResponse;
import com.sample.phm.exception.BadPurchaseException;
import com.sample.phm.exception.PurchaseNotFoundException;
import com.sample.phm.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase")
    public PurchaseResponse addPurchase(@RequestBody PurchaseRequest request) throws BadPurchaseException {
        return purchaseService.addNewPurchase(request);
    }

    @GetMapping("/purchase")
    public List<Purchase> getAllPurchase() {
        return purchaseService.getAllPurchase();
    }

    @GetMapping("/purchase/{id}")
    public PurchaseDetailsResponse getPurchase(@PathVariable Integer id) throws PurchaseNotFoundException {
        return purchaseService.getPurchaseDetails(id);
    }
}
