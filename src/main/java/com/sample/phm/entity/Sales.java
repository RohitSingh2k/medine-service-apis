package com.sample.phm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
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
