package com.sample.phm.controller;

import com.sample.phm.entity.Invoice;
import com.sample.phm.entity.InvoiceDetailsResponse;
import com.sample.phm.entity.InvoiceRequest;
import com.sample.phm.entity.InvoiceResponse;
import com.sample.phm.exception.*;
import com.sample.phm.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/invoice")
    public InvoiceResponse addInvoice(@RequestBody InvoiceRequest request) throws SaleQunatityGreaterThanStockException, StockNotFoundException, BadSalesCredentialsException, BadInvoiceException {
        return invoiceService.addNewInvoice(request);
    }

    @GetMapping("/invoice/{id}")
    public InvoiceDetailsResponse getInvoice(@PathVariable Integer id) throws InvoiceNotFoundException {
        return invoiceService.getInvoiceDetails(id);
    }

    @GetMapping("/invoice")
    public List<Invoice> getAllInvoice() {
        return invoiceService.getAllInvoice();
    }

}
