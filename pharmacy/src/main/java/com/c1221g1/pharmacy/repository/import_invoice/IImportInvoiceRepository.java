package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IImportInvoiceRepository extends JpaRepository<ImportInvoice,Integer> {

    @Query(value = "",
            countQuery = "",
            nativeQuery = true)
    Page<ImportInvoice> findAllImportInvoice(Pageable pageable);
}
