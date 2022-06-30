package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.dto.invoice.MedicineInvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
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
    /*
         Created by TrinhNN
         Function: create invoiceMedicine
         Role: Admin, Employee
     */
    @PostMapping(value = "/createWholesale")
    public ResponseEntity<Map<String, String>> createWholesaleInvoice(@Valid @RequestBody InvoiceMedicineDto invoiceMedicineDto,
                                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceWholeSale();
        Invoice invoice = new Invoice();
        invoice.setCustomer(invoiceMedicineDto.getCustomer());
        invoice.setEmployee(invoiceMedicineDto.getEmployee());
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceMedicineDto.getInvoiceNote());
        invoice.setInvoiceTotalMoney(invoice.getInvoiceTotalMoney());
        iInvoiceService.saveInvoice(invoice);
        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<MedicineInvoiceDto> medicineInvoiceDtoList = invoiceMedicineDto.getMedicines();
        for (int i = 0; i < medicineInvoiceDtoList.size(); i++) {
            Integer quantity = medicineInvoiceDtoList.get(i).getQuantity() ;
            Integer medicineId = medicineInvoiceDtoList.get(i).getId();
            iInvoiceMedicineService.createInvoiceMedicine(quantity,medicineId,newInvoice.getInvoiceId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
         Created by TrinhNN
         Function: create invoiceRefundMedicine
         Role: Admin, Employee
     */
    @PostMapping(value = "/createRefundsale")
    public ResponseEntity<Map<String, String>> createRefundInvoice(@Valid @RequestBody InvoiceMedicineDto invoiceMedicineDto,
                                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceWholeSale();
        Invoice invoice = new Invoice();
        invoice.setCustomer(invoiceMedicineDto.getCustomer());
        invoice.setEmployee(invoiceMedicineDto.getEmployee());
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceMedicineDto.getInvoiceNote());
        invoice.setInvoiceTotalMoney(invoice.getInvoiceTotalMoney());
        iInvoiceService.saveInvoice(invoice);
        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<MedicineInvoiceDto> medicineInvoiceDtoList = invoiceMedicineDto.getMedicines();
        for (int i = 0; i < medicineInvoiceDtoList.size(); i++) {
            Integer quantity = medicineInvoiceDtoList.get(i).getQuantity() ;
            Integer medicineId = medicineInvoiceDtoList.get(i).getId();
            iInvoiceMedicineService.createInvoiceMedicine(quantity,medicineId,newInvoice.getInvoiceId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
      /*
         Created by TrinhNN
         Function: update quantity
         Role: Admin, Employee
     */
    @PatchMapping(value = "/updateQuantityMedicine")
    public ResponseEntity<Map<String, String>> updateQuantityMedicine(@Validated @RequestBody InvoiceMedicineDto invoiceMedicineDto,
                                                                      BindingResult bindingResult) {
        String errorQuantity = "";
        Map<String, String> errorMap = new HashMap<>();
        if (!bindingResult.hasErrors()) {
            if (!invoiceMedicineDto.getMedicines().isEmpty()) {
                errorMap = checkListMedicine(invoiceMedicineDto.getMedicines());
                if (errorMap.isEmpty()) {
                    for (MedicineInvoiceDto medicineInvoiceDto : invoiceMedicineDto.getMedicines()) {
                        Optional<MedicineStorage> medicineStorage = iMedicineStorageService.getStorageByIdMedicine(medicineInvoiceDto.getId());
                        MedicineStorage storage = medicineStorage.orElse(null);
                        assert storage != null;
                        storage.setMedicineQuantity(storage.getMedicineQuantity() - medicineInvoiceDto.getQuantity());
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
     * Created by DaLQA
     * Time: 11:40 AM 30/06/2022
     * Function: function checkListMedicine
     * */
    public Map<String, String> checkListMedicine(List<MedicineInvoiceDto> medicineInvoiceDtoList) {
        String errorMessage = "";
        Map<String, String> errorMap = new HashMap<>();
        for (int i = 0; i <= medicineInvoiceDtoList.size() - 1; i++) {
            Optional<MedicineStorage> storages = iMedicineStorageService.getStorageByIdMedicine(medicineInvoiceDtoList.get(i).getId());
            MedicineStorage storage = storages.orElse(null);
            if (storage == null) {
                errorMessage = "Số lượng thuốc " + medicineInvoiceDtoList.get(i).getMedicineName() + " đã hết. Vui lòng chọn thuốc khác thay thế!";
                errorMap.put(String.valueOf(i), errorMessage);
            } else if (medicineInvoiceDtoList.get(i).getQuantity() > storage.getMedicineQuantity()) {
                errorMessage = "Số lượng thuốc " + storage.getMedicine().getMedicineName() + " trong tủ còn: " + storage.getMedicineQuantity();
                errorMap.put(String.valueOf(i), errorMessage);
            }
        }
        return errorMap;
    }
}

