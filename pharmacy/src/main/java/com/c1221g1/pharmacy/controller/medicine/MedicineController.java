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
     * this function use to create medicineOriginList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineOriginList")
    public List<MedicineOrigin> medicineOriginList() {
        return this.medicineOriginService.getAll();
    }

    /**
     * this function use to create medicineTypeList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineTypeList")
    public List<MedicineType> medicineTypeList() {
        return this.medicineTypeService.getAll();
    }

    /**
     * this function use to create medicineUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineUnitList")
    public List<MedicineUnit> medicineUnitList() {
        return this.medicineUnitService.getAll();
    }

    /**
     * this function use to create medicineConversionUnitList to modelAttribute
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @ModelAttribute("medicineConversionUnitList")
    public List<MedicineConversionUnit> medicineConversionUnitList() {
        return this.medicineConversionUnitService.getAll();
    }

    /**
     * this function use to create new medicine
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @PostMapping("")
    public ResponseEntity<List<FieldError>> createMedicine(@Valid @RequestBody MedicineDto medicineDto,
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
     * this function use to get all medicine unit
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineUnit")
    public ResponseEntity<List<MedicineUnit>> getMedicineUnitList() {
        List<MedicineUnit> medicineUnitList = this.medicineUnitList();
        if (medicineUnitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineUnitList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine conversion unit
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineConversionUnit")
    public ResponseEntity<List<MedicineConversionUnit>> getMedicineConversionUnitList() {
        List<MedicineConversionUnit> medicineConversionUnitList = this.medicineConversionUnitList();
        if (medicineConversionUnitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineConversionUnitList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine origin
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineOrigin")
    public ResponseEntity<List<MedicineOrigin>> getMedicineOriginList() {
        List<MedicineOrigin> medicineOriginList = this.medicineOriginList();
        if (medicineOriginList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineOriginList, HttpStatus.OK);
        }
    }

    /**
     * this function use to get all medicine type
     *
     * @author LongNH
     * @Time 09:42 03/07/2022
     */
    @GetMapping("medicineType")
    public ResponseEntity<List<MedicineType>> getMedicineTypeList() {
        List<MedicineType> medicineTypeList = this.medicineTypeList();
        if (medicineTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(medicineTypeList, HttpStatus.OK);
        }
    }

    /**
     * this function use to edit exist medicine
     *
     * @author LongNH
     * @Time 20:01 29/06/2022
     */
    @PatchMapping("{id}")
    public ResponseEntity<List<FieldError>> updateMedicine(@PathVariable("id") String id,
                                                           @Valid @RequestBody MedicineDto medicineDto,
                                                           BindingResult bindingResult) {
        Medicine existMedicine = this.medicineService.findMedicineById(id).orElse(null);
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
        existMedicine.setMedicineId(id);
        this.medicineService.updateMedicine(existMedicine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * this function use to get exist medicine in db
     *
     * @author LongNH
     * @Time 19:25 03/07/2022
     */
    @GetMapping("{id}")
    public ResponseEntity<Medicine> findMedicineById(@PathVariable("id") String id) {
        Medicine existMedicine = this.medicineService.findMedicineById(id).orElse(null);
        if (existMedicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existMedicine, HttpStatus.OK);
    }
}
