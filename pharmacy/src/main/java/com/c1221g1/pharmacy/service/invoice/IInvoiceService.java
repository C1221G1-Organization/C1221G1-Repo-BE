package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    Page<Invoice> findAllInvoice(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable);

    void delete(String id);

    Invoice findById(String id);
}
