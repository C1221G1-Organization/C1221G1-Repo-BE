package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.MedicineInvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository iInvoiceRepository;

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function saveInvoice
     * */
    @Override
    public void saveInvoice(Invoice invoice) {
        invoice.setInvoiceCreatedDate(LocalDate.now().toString());
        invoice.setInvoiceCreateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        this.iInvoiceRepository.save(invoice);
    }

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getNewInvoice
     * */
    @Override
    public Invoice getNewInvoice() {
        return this.iInvoiceRepository.getNewInvoice();
    }
}
