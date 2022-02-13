package com.sample.phm.service;

import com.sample.phm.entity.*;
import com.sample.phm.exception.*;
import com.sample.phm.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseHistoryService purchaseHistoryService;

    @Autowired
    StockService stockService;

    @Transactional(rollbackOn = {BadPurchaseException.class})
    public PurchaseResponse addNewPurchase(PurchaseRequest purchaseRequest) throws BadPurchaseException {
        try {
            Purchase purchase = null;
            if(purchaseRequest.getCompany() != null &&
                    purchaseRequest.getDetails() != null &&
                    purchaseRequest.getPayment_method() != null &&
                    purchaseRequest.getTotal_price() != null) {
                purchase = Purchase.builder().company(purchaseRequest.getCompany())
                        .date(LocalDateTime.now()).details(purchaseRequest.getDetails())
                        .payment_method(purchaseRequest.getPayment_method()).total_price(purchaseRequest.getTotal_price()).build();

                purchaseRepository.save(purchase);
            } else  {
                throw new BadPurchaseException("Invalid purchase");
            }
            for (PurchaseHistory purchaseHistory : purchaseRequest.getMedicine_list()) {

                purchaseHistory.setInvoice_id(purchase.getId());
                purchaseHistoryService.addPurchaseHistory(purchaseHistory);

                Stock stock = stockService.getStockByMedId(purchaseHistory.getMedicine_id());
                stock.setQuantity(stock.getQuantity() + purchaseHistory.getQuantity());
                stockService.addStock(stock);
            }
            return new PurchaseResponse(HttpStatus.ACCEPTED, true, "Purchase added successfully!");
        } catch (Exception ex) {
            throw new BadPurchaseException(ex.getMessage());
        }
    }

    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

//    public DeleteResponse deletePurchaseById(Integer id) throws PurchaseNotFoundException {
//        Optional<Purchase> purchase = purchaseRepository.findById(id);
//        if(purchase.isPresent()) {
//            purchaseRepository.delete(purchase.get());
//            return new DeleteResponse(HttpStatus.FOUND,true, "Purchase deleted succesfully");
//        } else {
//            throw new PurchaseNotFoundException("Purchase is not in database");
//        }
//    }

    public PurchaseDetailsResponse getPurchaseDetails(Integer id) throws PurchaseNotFoundException {

        PurchaseDetailsResponse res = new PurchaseDetailsResponse();

        Optional<Purchase> purchase = purchaseRepository.findById(id);

        if(purchase.isPresent()) {
            res.setPurchase(purchase.get());
            res.setHistories(purchaseHistoryService.getAllByInvoiceId(id));

            return res;
        } else {
            throw new PurchaseNotFoundException("Invoice not found in database");
        }

    }
}
