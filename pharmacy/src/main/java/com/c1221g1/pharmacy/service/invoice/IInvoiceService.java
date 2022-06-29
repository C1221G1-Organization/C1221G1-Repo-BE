package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    Page<Invoice> findAll(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable);

    Page<Invoice> findAllWithoutInvoiceTypeArg(String startDate, String endDate, String startTime, String endTime, Pageable pageable);

    void delete(String id);

    Invoice findById(String id);
}
