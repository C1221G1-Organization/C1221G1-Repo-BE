package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInvoiceRepository extends JpaRepository<Invoice,String> {
    @Query(value = "select invoice.invoice_id,")
    Page<Invoice> findAll(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable);
    @Query(value = "")
    Page<Invoice> findAllWithoutInvoiceTypeArg(String startDate, String endDate, String startTime, String endTime, Pageable pageable);
    @Query(value = "select invoice_id from invoice where invoice_id = id", nativeQuery = true)
    Invoice findInvoiceById(String id);
    @Query(value = "set sql_safe_updates = 0
            "update invoice +
            "set gia = gia*2 where ma_dich_vu_di_kem = (select ma_dich_vu_di_kem from `19_view`);\n" +
            "set sql_safe_updates = 1;")
    Invoice deleteByIdByFlag(String id);

}
