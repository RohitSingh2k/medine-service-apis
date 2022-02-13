package com.sample.phm.exception;

import com.sample.phm.entity.ErrorMessage;
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
}
