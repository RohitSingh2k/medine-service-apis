package com.sample.phm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {
    private HttpStatus status;
    private Boolean success;
    private String message;
}
