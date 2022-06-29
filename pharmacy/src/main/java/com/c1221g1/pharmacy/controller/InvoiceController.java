package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/manager-sale/invoice")
public class InvoiceController {
    @Autowired
    IInvoiceService iInvoiceService;

    /**
     * Create by TuanPA
     * Function: get all invoices, search/sort invoices
     */
    @GetMapping
    ResponseEntity<Page<Invoice>> getList(
                                    @RequestParam(defaultValue = "") String startDate,
                                    @RequestParam(defaultValue = "") String endDate,
                                    @RequestParam(defaultValue = "") String startTime,
                                    @RequestParam(defaultValue = "") String endTime,
                                    @RequestParam Integer typeOfInvoiceId,
                                    @RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "5") Integer size,
                                    @RequestParam(defaultValue = "invoiceId") String fieldSort) {
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,fieldSort);
        Page<Invoice> invoicePage;
        if (typeOfInvoiceId == 0) {
            invoicePage = iInvoiceService.findAllWithoutInvoiceTypeArg(startDate, endDate, startTime, endTime, pageable);
        } else {
            invoicePage = iInvoiceService.findAll(startDate, endDate, startTime, endTime, typeOfInvoiceId, pageable);
        }

        if(invoicePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invoicePage, HttpStatus.OK);
        }
    }

    /**
     * Created by TuanPA
     * Function: Delete invoice(set invoice flag 1->0)
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable String id) {
        Invoice invoice = iInvoiceService.findById(id);
        if (invoice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iInvoiceService.delete(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }
}
