package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITypeOfInvoiceRepository extends JpaRepository<TypeOfInvoice,Integer> {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getTypeOfInvoiceRetail
     * */
    @Query(value = "select * from type_of_invoice where type_of_invoice_id = 1;",nativeQuery = true)
    TypeOfInvoice getTypeOfInvoiceRetail();
}
