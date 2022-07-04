package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;

import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin()
@RequestMapping("/api/manager-sale/invoices")
public class InvoiceController {
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
                                                                   BindingResult bindingResult) {
        System.out.println(invoiceDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        try {
            boolean checkCreateInvoiceMedicine = this.iInvoiceMedicineService.saveInvoiceMedicine(invoiceDto);
            return new ResponseEntity<>(checkCreateInvoiceMedicine ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("errors", "số lượng trong kho không đủ");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Created by TrinhNN
     * Function: function createWholesaleInvoice
     * */
    @PostMapping("/createWholesale")
    public ResponseEntity<Map<String, String>> createWholesaleInvoice(@Validated @RequestBody
                                                                           InvoiceDto invoiceDto,
                                                                   BindingResult bindingResult) {
        System.out.println(invoiceDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        try {
            boolean checkCreateInvoiceMedicine = this.iInvoiceMedicineService.saveWholesaleInvoiceMedicine(invoiceDto);
            return new ResponseEntity<>(checkCreateInvoiceMedicine ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("errors", "số lượng trong kho không đủ");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Created by TrinhNN
     * Function: function createWholesaleInvoice
     * */
    @PostMapping("/createRefund")
    public ResponseEntity<Map<String, String>> createRefundInvoice(@Validated @RequestBody
                                                                              InvoiceDto invoiceDto,
                                                                      BindingResult bindingResult) {
        System.out.println(invoiceDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
            boolean checkCreateInvoiceMedicine = this.iInvoiceMedicineService.saveRefundInvoiceMedicine(invoiceDto);
            return new ResponseEntity<>(checkCreateInvoiceMedicine ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findInvoiceByInvoiceId(@PathVariable String id) {
        List<InvoiceMedicine> invoiceMedicines = iInvoiceMedicineService.findByInvoiceId(id);
        if(invoiceMedicines == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoiceMedicines,HttpStatus.OK);
    }
    @GetMapping("/medicine")
    public ResponseEntity<List<MedicineStorage>> getAllMedicine(){
        List<MedicineStorage> medicineStorageList = iMedicineStorageService.getAll();
        if(medicineStorageList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineStorageList, HttpStatus.OK);
    }

}



