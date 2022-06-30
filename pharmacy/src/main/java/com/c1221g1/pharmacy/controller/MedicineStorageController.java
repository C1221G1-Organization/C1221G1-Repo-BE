package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.medicine.MedicineStorageDto;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/manager-medicine/storage")
public class MedicineStorageController {
    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: Update item, item quantity in Medicine storage
     * if storage hasn't contain item, add item to storage
     * else increase quantity that item.
     *
     * @param medicineStorageDto
     * @param bindingResult
     */
    @PatchMapping("/updateStorage")
    public ResponseEntity<?> updateItem(@Validated @RequestBody MedicineStorageDto medicineStorageDto, BindingResult bindingResult) {
        new MedicineStorageDto().validate(medicineStorageDto, bindingResult);
        this.iMedicineStorageService.checkExistInMedicineStorage(medicineStorageDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            MedicineStorage medicineStorage = new MedicineStorage();
            medicineStorage.setMedicine(medicineStorageDto.getMedicine());
            medicineStorage.setMedicineQuantity(medicineStorageDto.getMedicineQuantity());
            medicineStorage.setFlag(true);
            iMedicineStorageService.addMedicineStorage(medicineStorage);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        this.iMedicineStorageService.updateStorageMedicineByMedicineId(medicineStorageDto.getMedicine(), medicineStorageDto.getMedicineQuantity());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
