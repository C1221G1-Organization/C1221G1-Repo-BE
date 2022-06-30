package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api/manager-medicine/medicines")
public class MedicineController {

    @Autowired
    private IMedicineService iMedicineService;

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @GetMapping("{medicineId}")
    public ResponseEntity<MedicineDetailDto> getMedicineDetailDtoById(@PathVariable("medicineId") String medicineId) {
        MedicineDetailDto medicineDetailDto = iMedicineService.getMedicineDetailDtoById(medicineId);
        if (medicineDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDto, HttpStatus.OK);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @GetMapping("get-5-relative-medicines-type/{medicineId}")
    public ResponseEntity<?> get5RelativeMedicinesOf(@PathVariable("medicineId") String medicineId) {
        List<MedicineDetailDto> medicineDetailDtoList = iMedicineService.get5RelativeMedicinesOf(medicineId);
        if (medicineDetailDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDtoList, HttpStatus.OK);
    }


}
