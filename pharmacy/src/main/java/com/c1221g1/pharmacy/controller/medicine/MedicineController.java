package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import java.util.List;
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
     * Creator: NghiaNTT
     * Time: 29/02/2022
     * @param id: medicineId
     * @return MedicineDetailDto contain properties to show customers
     */
    @GetMapping("{id}")
    public ResponseEntity<MedicineDetailDto> getMedicineDetailDtoById(@PathVariable("id") String id) {
        MedicineDetailDto medicineDetailDto = iMedicineService.getMedicineDetailDtoById(id);
        if (medicineDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDto, HttpStatus.OK);
    }
    /**
     * Creator: NghiaNTT
     * Time: 29/02/2022
     * @param id: medicineId
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @GetMapping("get5RelativeMedicinesOf/{id}")
    public ResponseEntity<List<MedicineDetailDto>> get5RelativeMedicinesOf(@PathVariable("id") String id) {
        List<MedicineDetailDto> medicineDetailDto = iMedicineService.get5RelativeMedicinesOf(id);
        if (medicineDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineDetailDto, HttpStatus.OK);
    }




}
