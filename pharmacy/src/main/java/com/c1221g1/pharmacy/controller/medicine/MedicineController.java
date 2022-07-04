package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.medicine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-medicine/medicines")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all page medicine
     */

    @GetMapping("/search")
    public ResponseEntity<?> findAllMedicine(@PageableDefault(value = 4) Pageable pageable,
                                             @RequestParam Optional<String> columName,
                                             @RequestParam Optional<String> condition,
                                             @RequestParam Optional<String> keyWord
    ) {
        String columNameValue = columName.orElse("medicineId");
        String conditionValue = condition.orElse("like");
        String keyWordValue = keyWord.orElse("'%%'");
        System.out.println(columNameValue);
        System.out.println(conditionValue);
        System.out.println(keyWordValue);
        List<MedicineLookUpDto> medicinePage = medicineService.findAllMedicine(columNameValue, conditionValue, keyWordValue);
        if (medicinePage.isEmpty()) {
            System.out.println(medicinePage);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), medicinePage.size());
        final Page<MedicineLookUpDto> page = new PageImpl<>(medicinePage.subList(start, end), pageable, medicinePage.size());
        return new ResponseEntity<>(page, HttpStatus.OK);
    }




    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Medicine> deleteMedicineById(@PathVariable String id) {
        Medicine medicine = this.medicineService.findMedicineById(id);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.medicineService.deleteMedicineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
