package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api/manager-sale/invoices")
public class InvoiceController {
@Autowired
    private IInvoiceService iInvoiceService;
    /*
         Created by TrinhNN
         Function: find buy invoice_id
         Role: Admin, Employee
     */


}
