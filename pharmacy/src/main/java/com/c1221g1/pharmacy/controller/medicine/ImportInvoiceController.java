package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.import_invoice.ImportInvoiceDto;
import com.c1221g1.pharmacy.dto.import_invoice.ImportInvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/manager-medicine/import-invoice")
public class ImportInvoiceController {

    @Autowired
    IImportInvoiceService iImportInvoiceService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: create ImportInvoice + save ImportInvoiceMedicine
     * and update MedicineStorage.
     *
     * @param importInvoiceDto
     * @return ResponseEntity
     */
    @PostMapping(value = "/createImportInvoice")
    public ResponseEntity<?> createImportInvoice(@Validated @RequestBody ImportInvoiceDto importInvoiceDto,
                                                 BindingResult bindingResult) {
        new ImportInvoiceDto().validate(importInvoiceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((
                        FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        ImportInvoice importInvoice = new ImportInvoice();
        BeanUtils.copyProperties(importInvoiceDto, importInvoice);
        ImportInvoice importInvoiceSave = this.iImportInvoiceService.saveImportInvoice(importInvoice);
        boolean checkSuccess = true;
        List<ImportInvoiceMedicineDto> importInvoiceMedicineDtoList = importInvoiceDto.getImportInvoiceMedicineList();
        List<ImportInvoiceMedicine> importInvoiceMedicineList = new ArrayList<>();
        for (int i = 0; i < importInvoiceMedicineDtoList.size(); i++) {
            ImportInvoiceMedicineDto importInvoiceMedicineDto = importInvoiceMedicineDtoList.get(i);
            new ImportInvoiceMedicineDto().validate(importInvoiceMedicineDto, bindingResult);
            if (bindingResult.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                bindingResult.getAllErrors().forEach((error) -> {
                    String fieldName = ((
                            FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            ImportInvoiceMedicine importInvoiceMedicine = new ImportInvoiceMedicine();
            BeanUtils.copyProperties(importInvoiceMedicineDto, importInvoiceMedicine);
            importInvoiceMedicine.setImportInvoice(importInvoiceSave);
            checkSuccess = this.iImportInvoiceService.saveImportInvoiceMedicine(importInvoiceMedicine);
            if (checkSuccess) {
                importInvoiceMedicineList.add(importInvoiceMedicine);
            } else {
                break;
            }
        }
        if (checkSuccess) {
            for (int i = 0; i < importInvoiceMedicineList.size(); i++) {
                ImportInvoiceMedicine importInvoiceMedicine = importInvoiceMedicineList.get(i);
                boolean flag = this.iImportInvoiceService.updateMedicineStorage(importInvoiceMedicine.getMedicine(),
                        importInvoiceMedicine.getImportInvoiceMedicineImportAmount());
            }
        }
        return new ResponseEntity<>(importInvoiceDto, HttpStatus.OK);
    }


}
