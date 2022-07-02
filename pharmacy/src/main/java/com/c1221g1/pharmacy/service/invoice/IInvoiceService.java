package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;

public interface IInvoiceService {
    void saveInvoice(Invoice invoice);

    Invoice getNewInvoice();


    Invoice findByInvoiceId(String invoiceId);
}
