package com.c1221g1.pharmacy.service.invoice;


public interface IInvoiceMedicineService {

    void createInvoiceMedicine(Integer quantity, Integer medicineId, String invoiceId);
}
