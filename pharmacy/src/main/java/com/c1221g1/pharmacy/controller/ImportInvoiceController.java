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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/manager-medicine/import-invoice")
public class ImportInvoiceController {

    @Autowired
    IImportInvoiceService importInvoiceService;

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @GetMapping(value = "")
    ResponseEntity<Page<ImportInvoice>> getPageListImportInvoice(
            @RequestParam Optional<String> startDate,
            @RequestParam Optional<String> endDate,
            @RequestParam Optional<String> startTime,
            @RequestParam Optional<String> endTime,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam Optional<String> fieldSort) {

        String startDateVal = startDate.orElse("");
        String endDateVal = endDate.orElse("");
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        String fieldSortVal = fieldSort.orElse("import_invoice_id");
        Pageable pageable = PageRequest.of(page,size, Sort.by(fieldSortVal).ascending());
        Page<ImportInvoice> importInvoicePage = importInvoiceService.findAllImportInvoice(startDateVal, endDateVal, startTimeVal, endTimeVal, pageable);

        if(importInvoicePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(importInvoicePage, HttpStatus.OK);
        }
    }

    @GetMapping(value = "ght")
    ResponseEntity<List<ImportInvoice>> getPage1() {

        List<ImportInvoice> importInvoicePage = importInvoiceService.findAll();

        if(importInvoicePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(importInvoicePage, HttpStatus.OK);
        }
    }

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImportInvoice(@PathVariable String id) {
        if("null".equals(id) || "".equals(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            importInvoiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
