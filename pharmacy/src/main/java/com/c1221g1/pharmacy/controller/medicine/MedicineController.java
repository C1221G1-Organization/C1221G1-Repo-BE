package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.*;
import com.c1221g1.pharmacy.service.medicine.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-medicine/medicines")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IMedicineOriginService medicineOriginService;
    @Autowired
    private IMedicineTypeService medicineTypeService;
    @Autowired
    private IMedicineUnitService medicineUnitService;
    @Autowired
    private IMedicineConversionUnitService medicineConversionUnitService;

    /**
     * this function use to push medicineOriginList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineOriginList")
    public List<MedicineOrigin> getMedicineOriginList() {
        return this.medicineOriginService.findAll();
    }

    /**
     * this function use to push medicineTypeList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineTypeList")
    public List<MedicineType> getMedicineTypeList() {
        return this.medicineTypeService.findAll();
    }

    /**
     * this function use to push medicineUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineUnitList")
    public List<MedicineUnit> getMedicineUnitList() {
        return this.medicineUnitService.findAll();
    }

    /**
     * this function use to push medicineConversionUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineConversionUnitList")
    public List<MedicineConversionUnit> getMedicineConversionUnitList() {
        return this.medicineConversionUnitService.findAll();
    }

    /**
     * this function use to create new medicine
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @PostMapping("")
    public ResponseEntity<List<FieldError>> createNewMedicine(@Valid @RequestBody MedicineDto medicineDto,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Medicine medicine = new Medicine();
        MedicineType medicineType = new MedicineType();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineType.setMedicineTypeId(medicineDto.getMedicineType().getMedicineTypeId());
        medicineOrigin.setMedicineOriginId(medicineDto.getMedicineOrigin().getMedicineOriginId());
        medicineUnit.setMedicineUnitId(medicineDto.getMedicineUnit().getMedicineUnitId());
        medicineConversionUnit.setMedicineConversionUnitId(medicineDto.getMedicineConversionUnit().getMedicineConversionUnitId());
        medicine.setMedicineType(medicineType);
        medicine.setMedicineOrigin(medicineOrigin);
        medicine.setMedicineUnit(medicineUnit);
        medicine.setMedicineConversionUnit(medicineConversionUnit);
        BeanUtils.copyProperties(medicineDto, medicine);
        this.medicineService.createMedicine(medicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * this function use to edit exist medicine
     *
     * @author LongNH
     * @Time 20:01 29/06/2022
     */
    @PutMapping("{id}")
    public ResponseEntity<List<FieldError>> updateMedicine(@PathVariable("id") String id,
                                                           @Valid @RequestBody MedicineDto medicineDto,
                                                           BindingResult bindingResult) {
        Medicine existMedicine = this.medicineService.findById(id).orElse(null);
        if (existMedicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MedicineType medicineType = new MedicineType();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineType.setMedicineTypeId(medicineDto.getMedicineType().getMedicineTypeId());
        medicineOrigin.setMedicineOriginId(medicineDto.getMedicineOrigin().getMedicineOriginId());
        medicineUnit.setMedicineUnitId(medicineDto.getMedicineUnit().getMedicineUnitId());
        medicineConversionUnit.setMedicineConversionUnitId(medicineDto.getMedicineConversionUnit().getMedicineConversionUnitId());
        existMedicine.setMedicineType(medicineType);
        existMedicine.setMedicineOrigin(medicineOrigin);
        existMedicine.setMedicineUnit(medicineUnit);
        existMedicine.setMedicineConversionUnit(medicineConversionUnit);
        BeanUtils.copyProperties(medicineDto, existMedicine);
        this.medicineService.updateMedicine(existMedicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
