package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository iInvoiceRepository;

    /*
     * Created by DaLQA
     * Time: 1:30 PM 02/07/2022
     * Function: function saveInvoice
     * */
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        invoice.setInvoiceCreatedDate(LocalDate.now().toString());
        invoice.setInvoiceCreateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        invoice.setFlag(true);
        return this.iInvoiceRepository.save(invoice);
    }

}
