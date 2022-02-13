package com.sample.phm.repository;

import com.sample.phm.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer> {

    @Query(value = "SELECT * FROM purchase_history s WHERE s.invoice_id = :inv_id", nativeQuery = true)
    List<PurchaseHistory> findAllByInvoice_id(@Param("inv_id")Integer id);
}
