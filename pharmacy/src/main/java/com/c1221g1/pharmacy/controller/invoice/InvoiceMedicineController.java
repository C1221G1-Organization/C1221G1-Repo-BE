package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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
    private IInvoiceMedicineService iInvoiceMedicineService;
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /*
     * Created by DaLQA
     * Time: 00:50 PM 30/06/2022
     * Function: function createRetailInvoice
     * */
    @PostMapping("/createRetail")
    public ResponseEntity<Map<String, String>> createRetailInvoice(@Validated @RequestBody
                                                                           InvoiceDto invoiceDto,
                                                                   BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        try {
            boolean checkCreateInvoiceMedicine = this.iInvoiceMedicineService.saveInvoiceMedicine(invoiceDto);
            return new ResponseEntity<>(checkCreateInvoiceMedicine ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            Map<String,String> errors = new HashMap<>();
            errors.put("errors","số lượng trong kho không đủ");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }
}
