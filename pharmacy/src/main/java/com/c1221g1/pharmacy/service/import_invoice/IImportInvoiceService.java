package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IImportInvoiceService {

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, String startTime, String endTime, Pageable pageable);

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    void deleteById(String id);
}
