package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manager-medicine/import-invoice")
public class ImportInvoiceController {

    @Autowired
    IImportInvoiceService importInvoiceService;

    @GetMapping
    ResponseEntity<Page<ImportInvoice>> getList(
            @RequestParam(defaultValue = "") String startDate,
            @RequestParam(defaultValue = "") String endDate,
            @RequestParam(defaultValue = "") String startTime,
            @RequestParam(defaultValue = "") String endTime,
            @RequestParam Integer typeOfInvoiceId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "invoiceId") String fieldSort) {
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,fieldSort);
        Page<ImportInvoice> importInvoicePage;
        importInvoicePage = importInvoiceService.findAllImportInvoice(startDate, endDate, startTime, endTime, pageable);

        if(importInvoicePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(importInvoicePage, HttpStatus.OK);
        }
    }

}
