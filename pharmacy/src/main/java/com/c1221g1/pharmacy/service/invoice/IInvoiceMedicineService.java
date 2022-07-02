package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;

public interface IInvoiceMedicineService {
    /*
     * Created by DaLQA
     * Time: 1:16 PM 02/07/2022
     * Function: function createInvoiceMedicine
     * */
    boolean saveInvoiceMedicine(InvoiceDto invoiceDto);
}
