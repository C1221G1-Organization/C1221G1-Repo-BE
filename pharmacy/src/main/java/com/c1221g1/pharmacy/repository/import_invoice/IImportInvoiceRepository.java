package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IImportInvoiceRepository extends JpaRepository<ImportInvoice, String> {

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @Query(value = "select import_invoice_id, import_system_code, import_invoice_date," +
                   "import_invoice_hour, payment_prepayment, total, flag, supplier_id," +
                   "employee_id" +
                   "from import_invoice " +
                   "where (import_invoice_date between :startDate and :endDate)" +
                   "and (import_invoice_hour between :startTime and :endTime) and flag = 1",

      countQuery ="select import_invoice_id, import_system_code, import_invoice_date," +
                   "import_invoice_hour, payment_prepayment, total, flag, supplier_id," +
                   "employee_id" +
                   "from import_invoice " +
                   "where (import_invoice_date between :startDate and :endDate)" +
                   "and (import_invoice_hour between :startTime and :endTime) and flag = 1",

      nativeQuery = true)
    Page<ImportInvoice> findAllImportInvoice(@Param("startDate") String startDate,
                                             @Param("endDate") String endDate,
                                             @Param("startTime") String startTime,
                                             @Param("endTime") String endTime,
                                             Pageable pageable);

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE import_invoice SET `flag` = 0 WHERE import_invoice_id = :id",
            nativeQuery = true)
    void deleteImportInvoice(@Param("id") String id);
}
