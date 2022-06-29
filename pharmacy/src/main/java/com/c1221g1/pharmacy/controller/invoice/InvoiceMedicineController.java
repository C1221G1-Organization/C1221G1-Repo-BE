package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;


/*
 * Created by DaLQA
 * Time: 4:12 PM 29/06/2022
 * Function: create InvoiceMedicineController and functions
 * */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/manager-sale/invoiceMedicines")
public class InvoiceMedicineController {
    @Autowired
    IInvoiceService iInvoiceService;
    @Autowired
    ITypeOfInvoiceService iTypeOfInvoiceService;
    @PostMapping("/createRetail")
    public ResponseEntity<Map<String, String>> createRetailInvoice(@Validated @RequestBody InvoiceMedicineDto invoiceMedicineDto,
                                                                   BindingResult bindingResult) {
        System.out.println(invoiceMedicineDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
