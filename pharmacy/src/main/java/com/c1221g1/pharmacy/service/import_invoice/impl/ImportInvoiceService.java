package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportInvoiceService implements IImportInvoiceService {
    @Autowired
    private IImportInvoiceRepository iImportInvoiceRepository;


}
