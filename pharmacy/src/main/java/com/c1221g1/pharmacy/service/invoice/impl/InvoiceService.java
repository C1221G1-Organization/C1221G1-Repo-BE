package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository iInvoiceRepository;
    @Override
    public Page<Invoice> findAll(String startDate, String endDate, String startTime, String endTime, Integer typeOfInvoiceId, Pageable pageable) {
        return iInvoiceRepository.findAll(startDate,endDate,startTime,endTime,typeOfInvoiceId,pageable);
    }

    public Page<Invoice> findAllWithoutInvoiceTypeArg(String startDate, String endDate, String startTime, String endTime, Pageable pageable) {
        return iInvoiceRepository.findAllWithoutInvoiceTypeArg(startDate, endDate, startTime, endTime, pageable);
    }

    @Override
    public void delete(String id) {
        iInvoiceRepository.deleteByFlag(id);
    }

    @Override
    public Invoice findById(String id) {
        return iInvoiceRepository.findInvoiceById(id);
    }
}
