package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportInvoiceService implements IImportInvoiceService {


    @Autowired
    private IImportInvoiceRepository importInvoiceRepository;

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @Override
    public Page<ImportInvoice> findAllImportInvoice(String startDate, String endDate, String startTime, String endTime, Pageable pageable) {
        return importInvoiceRepository.findAllImportInvoice(startDate, endDate, startTime, endTime, pageable);
    }

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @Override
    public void deleteById(String id) {
        importInvoiceRepository.deleteImportInvoice(id);
    }

    @Override
    public List<ImportInvoice> findAll() {
        return importInvoiceRepository.findAll1();
    }



}
