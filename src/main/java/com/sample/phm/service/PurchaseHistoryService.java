package com.sample.phm.service;

import com.sample.phm.entity.*;
import com.sample.phm.exception.BadPurchaseHistoryCredentialsException;
import com.sample.phm.repository.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService {

    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryResponse addPurchaseHistory(PurchaseHistory purchaseHistory) throws BadPurchaseHistoryCredentialsException {
        try {
            if(purchaseHistory.getDate() == null) {
                purchaseHistory.setDate(LocalDateTime.now());
                purchaseHistoryRepository.save(purchaseHistory);
            }   else {
                purchaseHistoryRepository.save(purchaseHistory);
            }
            return new PurchaseHistoryResponse(HttpStatus.ACCEPTED,true,"Purchase History added succesfully into database");
        } catch (Exception ex) {
            throw new BadPurchaseHistoryCredentialsException("Purchase History data are incomplete");
        }
    }

    public List<PurchaseHistory> getAllPurchaseHistory() {
        return purchaseHistoryRepository.findAll();
    }

    public List<PurchaseHistory> getAllByInvoiceId(Integer id) {
        return purchaseHistoryRepository.findAllByInvoice_id(id);
    }
}
