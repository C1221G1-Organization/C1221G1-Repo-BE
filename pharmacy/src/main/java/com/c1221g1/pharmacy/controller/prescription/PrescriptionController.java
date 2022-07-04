package com.c1221g1.pharmacy.controller.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
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

        Page<Prescription> prescriptionPage = this.prescriptionService.findAllPage(idVal, nameVal, targetVal, symptomVal, pageable);

        if (!prescriptionPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prescriptionPage, HttpStatus.OK);
    }
    /**
     * HienTLD
     * Chi tiết toa thuốc
     * 16:30 29/06/2022
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<IMedicinePrescriptionDto> getInfoPrescription(@PathVariable String id) {

        IMedicinePrescriptionDto medicinePrescriptionDto = this.prescriptionService.getPrescriptionById(id);

        if (medicinePrescriptionDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(medicinePrescriptionDto, HttpStatus.OK);
    }
}
