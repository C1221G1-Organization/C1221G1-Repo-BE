package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;

public interface IInvoiceService {
    Invoice saveInvoice(Invoice invoice);

    Invoice findByInvoiceId(String invoiceId);
}
