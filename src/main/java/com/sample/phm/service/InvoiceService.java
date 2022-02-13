package com.sample.phm.service;

import com.sample.phm.entity.*;
import com.sample.phm.exception.*;
import com.sample.phm.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    SalesService salesService;

    @Autowired
    StockService stockService;

//    public Integer addInvoice(Invoice invoice) throws BadInvoiceException {
//        try {
//            if (invoice.getDate() == null)
//                invoice.setDate(LocalDateTime.now());
//
//            invoiceRepository.save(invoice);
//            return invoice.getId();
//        } catch (Exception ex) {
//            throw new BadInvoiceException("Invoice is not valid");
//        }
//    }

    public DeleteResponse deleteInvoice(Integer id) throws InvoiceNotFoundException {

        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            invoiceRepository.delete(invoice.get());
            return new DeleteResponse(HttpStatus.FOUND, true, "Invoice deleted successfully");
        } else {
            throw new InvoiceNotFoundException("Invoice is not present into the database");
        }
    }

    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer id) throws InvoiceNotFoundException {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            return invoice.get();
        } else {
            throw new InvoiceNotFoundException("Invoice with this id is not present in database");
        }
    }

    @Transactional(rollbackOn = {BadSalesCredentialsException.class, StockNotFoundException.class, SaleQunatityGreaterThanStockException.class, BadInvoiceException.class})
    public InvoiceResponse addNewInvoice(InvoiceRequest invoiceRequest) throws BadSalesCredentialsException, StockNotFoundException, SaleQunatityGreaterThanStockException, BadInvoiceException {
        try {
            Invoice invoice = null;
            if(invoiceRequest.getCustomer_name() != null &&
                    invoiceRequest.getDetails() != null &&
                    invoiceRequest.getPayment_method() != null &&
                    invoiceRequest.getTotal_price() != null) {
                invoice = Invoice.builder().customer_name(invoiceRequest.getCustomer_name())
                        .date(LocalDateTime.now()).details(invoiceRequest.getDetails())
                        .payment_method(invoiceRequest.getPayment_method()).total_price(invoiceRequest.getTotal_price()).build();

                invoiceRepository.save(invoice);
            } else {
                throw new BadInvoiceException("Invalid invoide credentials");
            }
            for (Sales sale : invoiceRequest.getMedicine_list()) {

                sale.setInvoice_id(invoice.getId());
                salesService.addSales(sale);

                Stock stock = stockService.getStockByMedId(sale.getMedicine_id());
                if (stock.getQuantity() >= sale.getQuantity()) {
                    stock.setQuantity(stock.getQuantity() - sale.getQuantity());
                    stockService.addStock(stock);
                } else {
                    throw new SaleQunatityGreaterThanStockException("Qunatity is greater than stock");
                }
            }
            return new InvoiceResponse(HttpStatus.ACCEPTED, true, "Invoice added successfully!");
        } catch (Exception ex) {
            throw new BadInvoiceException("Invalid invoice to commit");
        }
    }

    public InvoiceDetailsResponse getInvoiceDetails(Integer id) throws InvoiceNotFoundException {

        InvoiceDetailsResponse res = new InvoiceDetailsResponse();

        Optional<Invoice> invoice = invoiceRepository.findById(id);

        if(invoice.isPresent()) {
            res.setInvoice(invoice.get());

            res.setSales(salesService.getSalesByInvoiceId(id));

            return res;
        } else {
            throw new InvoiceNotFoundException("Invoice not found in database");
        }

    }
}
