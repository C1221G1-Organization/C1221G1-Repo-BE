package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.medicine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-medicine/medicines")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IMedicineOriginService medicineOriginService;
    @Autowired
    private IMedicineConversionUnitService medicineConversionUnitService;
    @Autowired
    private IMedicineTypeService medicineTypeService;
    @Autowired
    private IMedicineUnitService medicineUnitService;

    @GetMapping("/list")
    public ResponseEntity<Page<Medicine>> findAllMedicine(@PageableDefault(value = 3) Pageable pageable,
                                                          @RequestParam Optional<String> medicineId,
                                                          @RequestParam Optional<String> medicineType,
                                                          @RequestParam Optional<String> medicineName,
                                                          @RequestParam Optional<String> medicineActiveIngredients,
                                                          @RequestParam Optional<String> importPrice,
                                                          @RequestParam Optional<String> wholesalePrice,
                                                          @RequestParam Optional<String> retailPrice) {
        String idValue = medicineId.orElse("");
        String medicineTypeValue = medicineType.orElse("");
        String medicineNameValue = medicineName.orElse("");
        String medicineActiveIngredientsValue = medicineActiveIngredients.orElse("");
        String importPriceValue = importPrice.orElse("");
        String wholesalePriceValue = wholesalePrice.orElse("");
        String retailPriceValue = retailPrice.orElse("");
        Page<Medicine> medicineList = medicineService.findAllMedicine(pageable, idValue, medicineTypeValue, medicineNameValue,
                medicineActiveIngredientsValue,importPriceValue, wholesalePriceValue, retailPriceValue);
        if (medicineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicineList,HttpStatus.OK);
    }

}
