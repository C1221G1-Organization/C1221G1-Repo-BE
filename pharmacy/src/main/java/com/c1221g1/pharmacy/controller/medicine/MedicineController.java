package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manager-medicine/medicines")
@CrossOrigin("**")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;

    /*
        Created by AnP
        Time: 18:00 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type And Sort
    */

    @GetMapping("")
    public ResponseEntity<Page<IMedicineDto>> getAllMedicineAndSearch(@RequestParam(defaultValue = "0") Integer page,
                                                                      @RequestParam(defaultValue = "5") Integer pageSize,
                                                                      @RequestParam Optional<String> sort,
                                                                      @RequestParam Optional<String> dir,
                                                                      @RequestParam Optional<String> name,
                                                                      @RequestParam Optional<Integer> typeId) {
        String nameVal = name.orElse("");
        Integer typeIdVal = typeId.orElse(null);
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");
        Pageable pageable;
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if (dirVal.equals("asc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }
        Page<IMedicineDto> medicineDtoPage = medicineService.getListAndSearch(pageable, nameVal, typeIdVal);
        if (!medicineDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineDtoPage, HttpStatus.OK);
    }

    /*
        Created by AnP
        Time: 20:45 29/06/2022
        Function: Get list 10 medicines best seller,
    */

    @GetMapping("/best-seller")
    public ResponseEntity<List<IMedicineDto>> getListMedicineBestSeller(){
        List<IMedicineDto> medicineDtoList = medicineService.getListMedicineBestSeller();
        if (medicineDtoList.size() ==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineDtoList, HttpStatus.OK);
    }
}
