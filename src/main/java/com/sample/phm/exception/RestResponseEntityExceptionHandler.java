package com.sample.phm.exception;

import com.sample.phm.entity.ErrorMessage;
import com.sample.phm.entity.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadUserCredentialsException.class)
    public ResponseEntity<ErrorMessage> invalidUserDetailsException (BadUserCredentialsException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(UserNotFoundExcetion.class)
    public ResponseEntity<ErrorMessage> userNotFoundExceptionHandler (UserNotFoundExcetion ex,WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(BadCompanyCredentialException.class)
    public ResponseEntity<ErrorMessage> badCompnayCredentialExceptionHandler(BadCompanyCredentialException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(CompanyNotExitsException.class)
    public ResponseEntity<ErrorMessage> companyNotExistExceptionHandler (CompanyNotExitsException ex,WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(BadMedicineCredentialException.class)
    public ResponseEntity<ErrorMessage> badMedicineCredentialExceptionHandler(BadMedicineCredentialException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(MedicineNotFoundException.class)
    public ResponseEntity<ErrorMessage> medicineNotFoundExceptionHandler (MedicineNotFoundException ex,WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(BadSalesCredentialsException.class)
    public ResponseEntity<ErrorMessage> badSalesCredentialExceptionHandler(BadSalesCredentialsException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(BadInvoiceException.class)
    public ResponseEntity<ErrorMessage> badSalesCredentialExceptionHandler(BadInvoiceException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<ErrorMessage> medicineNotFoundExceptionHandler (InvoiceNotFoundException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(InvalidPurchaseException.class)
    public ResponseEntity<ErrorMessage> badSalesCredentialExceptionHandler(InvalidPurchaseException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(PurchaseNotFoundException.class)
    public ResponseEntity<ErrorMessage> medicineNotFoundExceptionHandler (PurchaseNotFoundException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ErrorMessage> medicineNotFoundExceptionHandler (StockNotFoundException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(SaleQunatityGreaterThanStockException.class)
    public ResponseEntity<ErrorMessage> saleQunatityGreaterThanStockExceptionHandler (SaleQunatityGreaterThanStockException ex, WebRequest request) {
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST,false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
