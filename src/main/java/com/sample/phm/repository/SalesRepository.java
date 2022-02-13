package com.sample.phm.repository;

import com.sample.phm.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

    @Query(value = "SELECT * FROM sales s WHERE s.invoice_id = :inv_id", nativeQuery = true)
    List<Sales> findAllByInvoice_id(@Param("inv_id")Integer id);

}
