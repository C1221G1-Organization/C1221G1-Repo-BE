package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.IInvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
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
    public Page<IInvoiceDto> findAllInvoice(String startDate, String endDate, String startTime, String endTime, String typeOfInvoiceId, Pageable pageable) {
        return iInvoiceRepository.findAllInvoice(startDate,endDate,startTime,endTime,typeOfInvoiceId,pageable);
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
