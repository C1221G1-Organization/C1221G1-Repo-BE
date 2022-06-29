package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.dto.invoice.MedicineInvoiceDto;

import java.util.List;

public interface IInvoiceMedicineService {
    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    void createInvoiceMedicine(Integer quantity, Integer medicineInvoiceId, String invoiceId);
}
