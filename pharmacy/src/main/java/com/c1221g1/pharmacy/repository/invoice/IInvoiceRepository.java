package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInvoiceRepository extends JpaRepository<Invoice, String> {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getNewInvoice
     * */
    @Query(value = "select invoice_id, flag, invoice_create_time, invoice_created_date," +
            " invoice_note, customer_id,employee_id, type_of_invoice_id" +
            " from invoice " +
            "order by invoice.invoice_id " +
            "desc limit 1;",
            nativeQuery = true)
    Invoice getNewInvoice();
}
