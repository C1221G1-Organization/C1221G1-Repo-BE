package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceMedicineRepository extends JpaRepository<InvoiceMedicine,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into invoice_medicine (invoice_medicine_quantity,invoice_medicine_id ,invoice_id)" +
            " value (?1,?2,?3)", nativeQuery = true)
    void createInvoiceMedicine(Integer quantity, Integer medicineInvoiceId, String invoiceId);
}
