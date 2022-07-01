package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice,String> {
    /**
     * @author TuanPA
     * Function: find all invoice with all arguments in search field
     * @return invoice page
     */
//    @Query(value = "select invoice.invoice_id,customer_id,employee_id,invoice_created_date, invoice_created_time, invoice_note, " +
//            "       sum((medicine.medicine_retail_sale_profit + 1) * medicine.medicine_import_price)" +
//            " * invoice_medicine.invoice_medicine_quantity as invoice_total_money " +
//            "from medicine join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id " +
//            "join invoice on invoice_medicine.invoice_id = invoice.invoice_id " +
//            "where :startDate < invoice_created_date < :endDate "+
//            "and :startTime < invoice_created_time < :endTime "+
//            "and typeOfInvoiceId = :typeOfInvoiceId" +
//            "group by medicine.medicine_id", nativeQuery = true)
//    thêm thuộc tính invoiceTotalMoney ở invoice
    @Query(value = "select invoice.invoice_id,customer_id, employee_id, invoice_create_date," +
            " invoice_created_time, invoice_note, invoice_total_money " +
            "from invoice" +
            "where :startDate < invoice_created_date < :endDate "+
            "and :startTime < invoice_create_time < :endTime "+
            "and type_of_invoice_id = :typeOfInvoiceId", nativeQuery = true)
    Page<Invoice> findAll(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable);

    /**
     * @author TuanPA
     * function: find invoice by id
     * @return invoice
     */
    @Query(value = "select invoice_id from invoice where invoice_id = :id", nativeQuery = true)
    Invoice findInvoiceById(String id);


    /**
     * @author TuanPA
     * function: set invoice flag = 0
     * @return invoice
     */
    @Transactional
    @Modifying
    @Query(value="UPDATE invoice set flag = 0 where invoice_id = :id ", nativeQuery=true)
    Invoice deleteByFlag(String id);

}
