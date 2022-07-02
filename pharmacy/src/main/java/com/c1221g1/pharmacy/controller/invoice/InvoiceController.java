package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin()
@RequestMapping("/api/manager-sale/invoices")
public class InvoiceController {
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IInvoiceMedicineService iInvoiceMedicineService;
    /*
         Created by TrinhNN
         Function: find buy invoice_id
         Role: Admin, Employee
     */
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findInvoiceByInvoiceId(@PathVariable String id) {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        Invoice invoice = iInvoiceService.findByInvoiceId(id);
//        if (invoice == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        List<InvoiceMedicine> Medicines = this.iInvoiceMedicineService.findByInvoiceId(id);
//        invoiceDto.setMedicines(Medicines);
//        invoiceDto.setCustomer(invoice.getCustomer());
//        invoiceDto.setEmployee(invoice.getEmployee());
//        invoiceDto.setInvoiceCreatedDate(invoice.getInvoiceCreatedDate());
//        invoiceDto.setInvoiceNote(invoice.getInvoiceNote());
//        invoiceDto.setTypeOfInvoice(invoice.getTypeOfInvoice());
//        return new ResponseEntity<>(invoiceDto,HttpStatus.OK);
//    }
}
