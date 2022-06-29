package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.repository.invoice.ITypeOfInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfInvoiceService implements ITypeOfInvoiceService {
    @Autowired
    private ITypeOfInvoiceRepository iTypeOfInvoiceRepository;
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getTypeOfInvoiceRetail
     * */
    @Override
    public TypeOfInvoice getTypeOfInvoiceRetail() {
        return this.iTypeOfInvoiceRepository.getTypeOfInvoiceRetail();
    }
}
