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
    @Query(value = "select * from invoice order by id desc limit 1;", nativeQuery = true)
    Invoice getNewInvoice();
}
