package com.c1221g1.pharmacy.controller.prescription;

import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-prescription/prescriptions")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService prescriptionService;

    /**
     * HienTLD
     * Danh sách toa thuốc và tìm kiếm
     * 16:00 29/06/2022
     */
    @GetMapping("")
    public ResponseEntity<Page<Prescription>> getPagePrescription(@RequestParam Optional<String> id,
                                                                  @RequestParam Optional<String> names,
                                                                  @RequestParam Optional<String> target,
                                                                  @RequestParam Optional<String> symptom,
                                                                  @PageableDefault(value = 3) Pageable pageable) {
        String idVal = id.orElse("");
        String nameVal = names.orElse("");
        String targetVal = target.orElse("");
        String symptomVal = symptom.orElse("");

        Page<Prescription> prescriptionPage = this.prescriptionService.findAll(idVal, nameVal, targetVal, symptomVal, pageable);

        if (!prescriptionPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prescriptionPage, HttpStatus.OK);
    }

    /**
     * HienTLD
     * Thêm mới toa thuốc
     * 16:30 29/06/2022
     */
    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createPrescription(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        Prescription prescription = new Prescription();

        BeanUtils.copyProperties(prescriptionDto, prescription);

        this.prescriptionService.save(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * HienTLD
     * Xoá toa thuốc (xoá theo cờ 'flag')
     * 16:00 29/06/2022
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable("id") String id) {
        try {
            this.prescriptionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * HienTLD
     * Sửa toa thuốc (xoá theo cờ 'flag')
     * update 11:18 30/06/2022
     */
    @PatchMapping("/edit/{id}")
    public ResponseEntity<List<FieldError>> editSmartPhone(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                           BindingResult bindingResult,
                                                           @PathVariable String id) throws NotEmpty {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors() ,HttpStatus.BAD_REQUEST);
        }
        Prescription prescription = new Prescription();

        prescription.setPrescriptionId(id);

        prescription.setFlag(true);

        BeanUtils.copyProperties(prescriptionDto, prescription);

        this.prescriptionService.edit(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
