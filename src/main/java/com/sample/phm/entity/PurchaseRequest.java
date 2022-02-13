package com.sample.phm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseRequest {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String company;

    @NotBlank
    private LocalDateTime date;

    @NotBlank
    private String details;

    @NotBlank
    private String payment_method;

    @NotBlank
    private String total_price;

    private ArrayList<PurchaseHistory> medicine_list;
}
