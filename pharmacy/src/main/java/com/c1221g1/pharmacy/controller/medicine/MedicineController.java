package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.medicine.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<MedicineLookUpDto>> findAllMedicine(
                                                          @RequestParam Optional<String> columName,
                                                          @RequestParam Optional<String> condition,
                                                          @RequestParam Optional<String> keyWord
                                                          ) {
        String columNameValue = columName.orElse("wholesale_price");
        String conditionValue = condition.orElse(">");
        String keyWordValue = keyWord.orElse("200000");
        List<MedicineLookUpDto> medicinePage = medicineService.findAllMedicine(columNameValue,conditionValue,keyWordValue);
        if (medicinePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicinePage, HttpStatus.OK);
    }

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get list medicine
     */

    @GetMapping("/")
    public ResponseEntity<List<Medicine>> getList(){
      List<Medicine> medicineList = medicineService.getListMedicine();
      if (medicineList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(medicineList,HttpStatus.OK);
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
