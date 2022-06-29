package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api/manager-sale/invoices")
public class InvoiceMedicineController {
    @Autowired
private IInvoiceService iInvoiceService;
}
