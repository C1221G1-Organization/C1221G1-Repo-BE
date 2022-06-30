package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IImportInvoiceService {
    Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, String startTime, String endTime, Pageable pageable);

    void deleteById(String id);

    List<ImportInvoice> findAll();
}
