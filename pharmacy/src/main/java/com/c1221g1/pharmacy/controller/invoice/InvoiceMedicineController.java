package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.BeanUtils;
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
                                                                   BindingResult bindingResult) {
        System.out.println(invoiceDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        boolean checkCreateInvoiceMedicine = this.iInvoiceMedicineService.saveInvoiceMedicine(invoiceDto);
        return new ResponseEntity<>(checkCreateInvoiceMedicine ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
//
    /*
     * Created by DaLQA
     * Time: 00:50 PM 30/06/2022
     * Function: function updateQuantityMedicine
     * */
//    @PatchMapping("/updateQuantityMedicine")
//    public ResponseEntity<Map<String, String>> updateQuantityMedicine(@Validated @RequestBody
//                                                                              InvoiceDto invoiceDto,
//                                                                      BindingResult bindingResult) {
//        String errorQuantity = "";
//        Map<String, String> errorMap = new HashMap<>();
//        if (!bindingResult.hasErrors()) {
//            if (!invoiceDto.getInvoiceMedicineList().isEmpty()) {
//                errorMap = checkListMedicine(invoiceDto.getInvoiceMedicineList());
//                if (errorMap.isEmpty()) {
//                    for (InvoiceMedicineDto invoiceMedicineDto : invoiceDto.getInvoiceMedicineList()) {
//                        Optional<MedicineStorage> medicineStorage = iMedicineStorageService
//                                .getStorageByIdMedicine(invoiceMedicineDto.getMedicine().getMedicineId());
//                        MedicineStorage storage = medicineStorage.orElse(null);
//                        assert storage != null;
//                        storage.setMedicineQuantity
//                                (storage.getMedicineQuantity() - invoiceMedicineDto.getInvoiceMedicineQuantity());
//                        iMedicineStorageService.updateMedicineQuantity(storage);
//                    }
//                    return new ResponseEntity<>(HttpStatus.OK);
//                } else {
//                    return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
//                }
//            } else {
//                errorQuantity = "Bạn chưa chọn thuốc";
//                errorMap.put("medicineList", errorQuantity);
//                return new ResponseEntity<>(errorMap,
//                        HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            errorQuantity = "Vui lòng nhập đủ thông tin";
//            errorMap.put("validMedicine", errorQuantity);
//            return new ResponseEntity<>(errorMap,
//                    HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    /*
//     * Created by DaLQA
//     * Time: 11:40 AM 30/06/2022
//     * Function: function checkListMedicine
//     * */
//    public Map<String, String> checkListMedicine(List<InvoiceMedicineDto> invoiceMedicineDtoList) {
//        String errorMessage = "";
//        Map<String, String> errorMap = new HashMap<>();
//        for (int i = 0; i <= invoiceMedicineDtoList.size() - 1; i++) {
//            Optional<MedicineStorage> storages = iMedicineStorageService.getStorageByIdMedicine(invoiceMedicineDtoList
//                                                                             .get(i).getMedicine().getMedicineId());
//            MedicineStorage storage = storages.orElse(null);
//            if (storage == null) {
//                errorMessage = "Số lượng thuốc " + invoiceMedicineDtoList.get(i).getMedicine().getMedicineName()
//                        + " đã hết. Vui lòng chọn thuốc khác thay thế!";
//                errorMap.put(String.valueOf(i), errorMessage);
//            } else if (invoiceMedicineDtoList.get(i).getInvoiceMedicineQuantity() > storage.getMedicineQuantity()) {
//                errorMessage = "Số lượng thuốc " + storage.getMedicine().getMedicineName() +
//                        " trong tủ còn: " + storage.getMedicineQuantity();
//                errorMap.put(String.valueOf(i), errorMessage);
//            }
//        }
//        return errorMap;
//    }
}
