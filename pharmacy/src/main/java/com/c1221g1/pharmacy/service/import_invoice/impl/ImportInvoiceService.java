package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImportInvoiceService implements IImportInvoiceService {

    @Autowired
    private IImportInvoiceRepository importInvoiceRepository;

    @Override
    public Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, String startTime, String endTime, Pageable pageable) {
        return importInvoiceRepository.findAllImportInvoice();
    }
}
