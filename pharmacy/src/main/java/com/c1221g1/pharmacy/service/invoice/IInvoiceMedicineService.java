package com.c1221g1.pharmacy.service.invoice;


import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;

import java.util.List;

public interface IInvoiceMedicineService {

    void createInvoiceMedicine(Integer quantity, String medicineId, String invoiceId);

    List<InvoiceMedicine> findByInvoiceId(String id);
}
