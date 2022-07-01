package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.repository.invoice.IInvoiceMedicineRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceMedicineService implements IInvoiceMedicineService {
    @Autowired
    private IInvoiceMedicineRepository invoiceMedicineRepository;

    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    @Override
    public void createInvoiceMedicine(Integer quantity, String medicineId, String invoiceId) {
        this.invoiceMedicineRepository.createInvoiceMedicine(quantity, medicineId, invoiceId);
    }
}
