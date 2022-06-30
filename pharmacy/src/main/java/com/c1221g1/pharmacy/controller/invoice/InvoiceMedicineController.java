package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.dto.invoice.MedicineInvoiceDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    private IInvoiceMedicineService iInvoiceMedicineService;
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private ITypeOfInvoiceService iTypeOfInvoiceService;
    @Autowired
    private ICustomerService iCustomerService;

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function createRetailInvoice
     * */
    @PostMapping("/createRetail")
    public ResponseEntity<Map<String, String>> createRetailInvoice(@Validated @RequestBody InvoiceMedicineDto invoiceMedicineDto,
                                                                   BindingResult bindingResult) {
        System.out.println(invoiceMedicineDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(invoiceMedicineDto.getCustomerDto(), customer);
        if (invoiceMedicineDto.getCustomerDto().getCustomerId() == null) {
            customer = iCustomerService.getRetailCustomer();
        }
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceRetail();
        Invoice invoice = new Invoice();
        invoice.setInvoiceTotalMoney(invoiceMedicineDto.getInvoiceTotalMoney());
        invoice.setCustomer(customer);
        invoice.setInvoiceNote(invoiceMedicineDto.getInvoiceNote());
        invoice.setTypeOfInvoice(typeOfInvoice);
        iInvoiceService.saveInvoice(invoice);
        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<MedicineInvoiceDto> list = invoiceMedicineDto.getMedicines();
        for (int i = 0; i < list.size(); i++) {
            Integer quantity = list.get(i).getQuantity();
            Integer medicineInvoiceId = list.get(i).getId();
            iInvoiceMedicineService.createInvoiceMedicine(quantity, medicineInvoiceId, newInvoice.getInvoiceId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * Created by DaLQA
     * Time: 00:50 PM 30/06/2022
     * Function: function updateQuantityMedicine
     * */
//    @PatchMapping("/updateQuantityMedicine")
//    public ResponseEntity<Map<String,String>> updateQuantityMedicine (@Validated @RequestBody InvoiceMedicineDto invoiceMedicineDto,
//                                                                      BindingResult bindingResult){
//        String errorQuantity = "";
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError());
//            Map<String, String> errorMap = bindingResult.getFieldErrors()
//                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
