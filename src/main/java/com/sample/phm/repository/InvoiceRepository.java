package com.sample.phm.repository;

import com.sample.phm.entity.Invoice;
import com.sample.phm.entity.InvoiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
