package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.invoice.IInvoiceDto;
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

import java.time.LocalDate;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/manager-sale/invoices")
public class InvoiceController {
    @Autowired
    IInvoiceService iInvoiceService;

    /**
     * Create by TuanPA
     * Function: get all invoices, search/sort invoices
     */
//    @GetMapping
//    ResponseEntity<Page<Invoice>> getListInvoice(
//                                    @RequestParam(defaultValue = "") String startDate,
//                                    @RequestParam(defaultValue = "") String endDate,
//                                    @RequestParam(defaultValue = "") String startTime,
//                                    @RequestParam(defaultValue = "") String endTime,
//                                    @RequestParam(defaultValue = "1") Integer typeOfInvoiceId,
//                                    @RequestParam(defaultValue = "invoiceId") String fieldSort) {
//        Pageable pageable = PageRequest.of(0,5, Sort.Direction.ASC,fieldSort);
//        Page<Invoice> invoicePage = iInvoiceService.findAllInvoice(startDate, endDate, startTime, endTime, typeOfInvoiceId, pageable);
//        if(invoicePage.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(invoicePage, HttpStatus.OK);
//        }
//    }
    @GetMapping("")
    ResponseEntity<Page<IInvoiceDto>> getListInvoice(
            @RequestParam(defaultValue = "") String startDate,
            @RequestParam Optional<String> endDate,
            @RequestParam(defaultValue = "") String startTime,
            @RequestParam(defaultValue = "23:59") String endTime,
            @RequestParam(defaultValue = "1") String typeOfInvoiceId,
            @RequestParam(defaultValue = "invoiceId") String fieldSort) {
        String endDateVal = endDate.orElse(String.valueOf(LocalDate.now()));
        Pageable pageable;
        if (fieldSort.equals("time")) {
//            pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("invoiceCreatedDate"), Sort.Order.asc("invoiceCreateTime")));
            pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "invoiceCreatedDate", "invoiceCreateTime");
        } else {
            pageable = PageRequest.of(0, 5, Sort.by(fieldSort).ascending());
        }
        Page<IInvoiceDto> invoicePage = iInvoiceService.findAllInvoice(startDate, endDateVal, startTime, endTime, typeOfInvoiceId, pageable);
        if (invoicePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invoicePage, HttpStatus.OK);
        }
    }

    /**
     * Created by TuanPA
     * Function: Delete invoice(set invoice flag 1->0)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable String id) {
        Invoice invoice = iInvoiceService.findById(id);
        if (invoice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iInvoiceService.delete(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }
}