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
    @Query(value = "select invoice.invoice_id,customer_id,employee_id,invoice_created_date,invoice_note, " +
            "       sum(invoice_medicine.invoice_medicine_quantity * medicine.medicine_conversion_rate * medicine.medicine_retail_sale_profit * medicine.medicine_import_price) " +
            "from medicine join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id " +
            "join invoice on invoice_medicine.invoice_id = invoice.invoice_id " +
            "group by medicine.medicine_id" +
            "having :startDate < invoice_created_date < :endDate "+
            "and :startTime < invoice_created_time < :endTime "+
            "and typeOfInvoiceId = :typeOfInvoiceId", nativeQuery = true)
    Page<Invoice> findAll(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable);

    /**
     * @author TuanPA
     * Function: find all invoice without typeOfInVoiceId argument
     * @return invoice page
     */
    @Query(value = "select invoice.invoice_id,customer_id,employee_id,invoice_created_date,invoice_note, " +
            "       sum(invoice_medicine.invoice_medicine_quantity * medicine.medicine_conversion_rate * medicine.medicine_retail_sale_profit * medicine.medicine_import_price) " +
            "from medicine join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id " +
            "join invoice on invoice_medicine.invoice_id = invoice.invoice_id " +
            "group by medicine.medicine_id" +
            "having :startDate < invoice_created_date < :endDate "+
            "and :startTime < invoice_created_time < :endTime ", nativeQuery = true)
    Page<Invoice> findAllWithoutInvoiceTypeArg(String startDate, String endDate, String startTime, String endTime, Pageable pageable);

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
