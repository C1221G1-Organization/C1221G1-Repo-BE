package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService {
    Page<Prescription> findAllPage(String idVal, String nameVal, String targetVal, String symptomVal, Pageable pageable);

    IMedicinePrescriptionDto getPrescriptionById(String id);
}
