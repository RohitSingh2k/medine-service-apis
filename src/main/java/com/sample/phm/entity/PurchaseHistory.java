package com.sample.phm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "purchase_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String medicine_name;
    private String company_name;
    private Integer invoice_id;
    private Integer cost;
    private Integer quantity;
    private LocalDateTime date;
    private String volume;
    private Integer medicine_id;
}
