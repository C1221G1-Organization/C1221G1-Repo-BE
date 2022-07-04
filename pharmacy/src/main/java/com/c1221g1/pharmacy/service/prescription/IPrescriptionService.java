package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrescriptionService {
    Page<Prescription> findAllPageAndSearch(Pageable pageable, String id, String name, String target, String symptom);

    void save(Prescription prescription);

    Prescription findById(String id);

    void deleteById(String id);

    void edit(Prescription prescription);

    IMedicinePrescriptionDto getPrescriptionById(String id);

    boolean savePrescription()
}
