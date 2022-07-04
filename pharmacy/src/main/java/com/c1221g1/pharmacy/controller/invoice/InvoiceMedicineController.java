package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
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
    private IMedicineService iMedicineService;

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
        } catch (NullPointerException ex) {
            Map<String,String> errors = new HashMap<>();
            errors.put("errors", ex.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            Map<String,String> errors = new HashMap<>();
            errors.put("errors","số lượng " + e.getMessage() + " trong kho không đủ" );
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }
    /*
     * Created by DaLQA
     * Time: 10:30 PM 3/07/2022
     * Function: function getListMedicine
     * */
    @GetMapping("/getMedicines")
    public ResponseEntity<List<MedicineSale>> getListMedicine(){
        List<MedicineSale> medicineSaleDtoList = this.iMedicineService.getListMedicineSale();
        if(medicineSaleDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineSaleDtoList, HttpStatus.OK);
    }
}
