package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("/api/manager-sale/invoices")
public class InvoiceMedicineController {
    @Autowired
    private IInvoiceService iInvoiceService;

    @Autowired
    private IInvoiceMedicineService iInvoiceMedicineService;

    @Autowired
    private ITypeOfInvoiceService iTypeOfInvoiceService;

    @Autowired
    private IMedicineStorageService iMedicineStorageService;
    /*
         Created by TrinhNN
         Function: create invoiceMedicine
         Role: Admin, Employee
     */
    @PostMapping(value = "/wholesale")
    public ResponseEntity<Map<String, String>> createWholesaleInvoice(@Valid @RequestBody InvoiceDto invoiceDto,
                                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceWholeSale();
        Invoice invoice = new Invoice();
        invoice.setCustomer(invoiceDto.getCustomer());
        invoice.setEmployee(invoiceDto.getEmployee());
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        invoice.setInvoiceTotalMoney(invoice.getInvoiceTotalMoney());
        iInvoiceService.saveInvoice(invoice);
        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<InvoiceMedicineDto> medicineInvoiceDtoList = invoiceDto.getInvoiceMedicineList();
        for (int i = 0; i < medicineInvoiceDtoList.size(); i++) {
            Integer quantity = medicineInvoiceDtoList.get(i).getInvoiceMedicineQuantity();
            String medicineId = medicineInvoiceDtoList.get(i).getMedicine().getMedicineId();
            iInvoiceMedicineService.createInvoiceMedicine(quantity, medicineId, newInvoice.getInvoiceId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
         Created by TrinhNN
         Function: create invoiceRefundMedicine
         Role: Admin, Employee
     */
    @PostMapping(value = "/refund")
    public ResponseEntity<Map<String, String>> createRefundInvoice(@Valid @RequestBody InvoiceDto invoiceDto,
                                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceWholeSale();
        Invoice invoice = new Invoice();
        invoice.setCustomer(invoiceDto.getCustomer());
        invoice.setEmployee(invoiceDto.getEmployee());
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        invoice.setInvoiceTotalMoney(invoice.getInvoiceTotalMoney());
        iInvoiceService.saveInvoice(invoice);
        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<InvoiceMedicineDto> medicineInvoiceDtoList = invoiceDto.getInvoiceMedicineList();
        for (int i = 0; i < medicineInvoiceDtoList.size(); i++) {
            Integer quantity = medicineInvoiceDtoList.get(i).getInvoiceMedicineQuantity();
            String medicineId = medicineInvoiceDtoList.get(i).getMedicine().getMedicineId();
            iInvoiceMedicineService.createInvoiceMedicine(quantity, medicineId, newInvoice.getInvoiceId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
       Created by TrinhNN
       Function: update quantity wholesale
       Role: Admin, Employee
   */
    @PatchMapping(value = "/updateQuantityMedicine")
    public ResponseEntity<Map<String, String>> updateQuantityMedicine(@Validated @RequestBody InvoiceDto invoiceDto,
                                                                      BindingResult bindingResult) {
        String errorQuantity = "";
        Map<String, String> errorMap = new HashMap<>();
        if (!bindingResult.hasErrors()) {
            if (!invoiceDto.getInvoiceMedicineList().isEmpty()) {
                errorMap = checkListMedicine(invoiceDto.getInvoiceMedicineList());
                if (errorMap.isEmpty()) {
                    for (InvoiceMedicineDto invoiceMedicineDto : invoiceDto.getInvoiceMedicineList()) {
                        Optional<MedicineStorage> medicineStorage = iMedicineStorageService.getStorageByIdMedicine(invoiceMedicineDto.getMedicine().getMedicineId());
                        MedicineStorage storage = medicineStorage.orElse(null);
                        assert storage != null;
                        storage.setMedicineQuantity(storage.getMedicineQuantity() - invoiceMedicineDto.getInvoiceMedicineQuantity());
                        iMedicineStorageService.updateMedicineQuantity(storage);
                    }
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
                }
            } else {
                errorQuantity = "Bạn chưa chọn thuốc";
                errorMap.put("medicineList", errorQuantity);
                return new ResponseEntity<>(errorMap,
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            errorQuantity = "Vui lòng nhập đủ thông tin";
            errorMap.put("validMedicine", errorQuantity);
            return new ResponseEntity<>(errorMap,
                    HttpStatus.BAD_REQUEST);
        }
    }
    /*
          Created by TrinhNN
          Function:function checkListMedicine
          Role: Admin, Employee
      */
    public Map<String, String> checkListMedicine(List<InvoiceMedicineDto> invoiceMedicineDtoList) {
        String errorMessage = "";
        Map<String, String> errorMap = new HashMap<>();
        for (int i = 0; i <= invoiceMedicineDtoList.size() - 1; i++) {
            Optional<MedicineStorage> storages = iMedicineStorageService.getStorageByIdMedicine(invoiceMedicineDtoList
                    .get(i).getMedicine().getMedicineId());
            MedicineStorage storage = storages.orElse(null);
            if (storage == null) {
                errorMessage = "Số lượng thuốc " + invoiceMedicineDtoList.get(i).getMedicine().getMedicineName()
                        + " đã hết. Vui lòng chọn thuốc khác thay thế!";
                errorMap.put(String.valueOf(i), errorMessage);
            } else if (invoiceMedicineDtoList.get(i).getInvoiceMedicineQuantity() > storage.getMedicineQuantity()) {
                errorMessage = "Số lượng thuốc " + storage.getMedicine().getMedicineName() +
                        " trong tủ còn: " + storage.getMedicineQuantity();
                errorMap.put(String.valueOf(i), errorMessage);
            }
        }
        return errorMap;
    }
    /*
          Created by TrinhNN
          Function:update quantity refund
          Role: Admin, Employee
      */
    @PatchMapping(value = "/updateQuantityMedicineRefund")
    public ResponseEntity<?> updateQuantityMedicineRefund(@Validated @RequestBody InvoiceDto invoiceDto,
                                                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {for (InvoiceMedicineDto invoiceMedicineDto : invoiceDto.getInvoiceMedicineList()) {
            Optional<MedicineStorage> medicineStorage = iMedicineStorageService.getStorageByIdMedicine(invoiceMedicineDto.getMedicine().getMedicineId());
            MedicineStorage storage = medicineStorage.orElse(null);
            assert storage != null;
            storage.setMedicineQuantity(storage.getMedicineQuantity() + invoiceMedicineDto.getInvoiceMedicineQuantity());
            iMedicineStorageService.updateMedicineQuantity(storage);
        }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    /*
         Created by TrinhNN
         Function: find Invoice by invoice id
         Role: Admin, Employee
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findInvoiceByInvoiceId(@PathVariable String id) {
       List<InvoiceMedicine> invoiceMedicines = iInvoiceMedicineService.findByInvoiceId(id);
       if(invoiceMedicines == null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(invoiceMedicines,HttpStatus.OK);
    }
}

