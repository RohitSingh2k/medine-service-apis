package com.sample.phm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    private Integer id;

    private String company;
    private LocalDateTime date;
    private String details;
    private String payment_method;
    private Integer total_price;
}
