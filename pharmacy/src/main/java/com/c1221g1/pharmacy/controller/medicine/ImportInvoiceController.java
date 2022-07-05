package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.import_invoice.ImportInvoiceDto;
import com.c1221g1.pharmacy.dto.import_invoice.ImportInvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("api/manager-medicine/import-invoice")
public class ImportInvoiceController {

    @Autowired
    private IImportInvoiceService importInvoiceService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: create ImportInvoice + save ImportInvoiceMedicine
     * and update MedicineStorage.
     *
     * @param importInvoiceDto
     * @return ResponseEntity
     */
    @PostMapping(value = "/importInvoice")
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
        ImportInvoice importInvoiceSave = this.importInvoiceService.saveImportInvoice(importInvoice);
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
            checkSuccess = this.importInvoiceService.saveImportInvoiceMedicine(importInvoiceMedicine);
            if (checkSuccess) {
                importInvoiceMedicineList.add(importInvoiceMedicine);
            } else {
                break;
            }
        }
        if (checkSuccess) {
            for (int i = 0; i < importInvoiceMedicineList.size(); i++) {
                ImportInvoiceMedicine importInvoiceMedicine = importInvoiceMedicineList.get(i);
                boolean flag = this.importInvoiceService.updateMedicineStorage(importInvoiceMedicine.getMedicine(),
                        importInvoiceMedicine.getImportInvoiceMedicineImportAmount());
            }
        }
        return new ResponseEntity<>(importInvoiceDto, HttpStatus.OK);
    }

    /**
     * this function use to get all list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @GetMapping(value = "")
    ResponseEntity<Page<ImportInvoice>> getPageListImportInvoice(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String startTime,
            @RequestParam String endTime,
            @RequestParam (defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam String fieldSort) {

        if ("".equals(endDate)) {
            endDate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
        }
        if ("".equals(endTime)) {
            endTime = "23:59";
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(fieldSort).ascending());
        Page<ImportInvoice> importInvoicePage = importInvoiceService.findAllImportInvoice(startDate, endDate, startTime, endTime, pageable);

        if (importInvoicePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(importInvoicePage, HttpStatus.OK);
        }
    }

    /**
     * this function use to delete flag from list Import Invoice
     *
     * @author HongHTX
     * @Time 17:00 29/06/2022
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImportInvoice(@PathVariable String id) {
        if ("null".equals(id) || "".equals(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            importInvoiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
