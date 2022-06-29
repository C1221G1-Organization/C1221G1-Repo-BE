package com.c1221g1.pharmacy.service.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;

public interface IInvoiceService {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function saveInvoice
     * */
    void saveInvoice(Invoice invoice);
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getNewInvoice
     * */
    Invoice getNewInvoice();
}
