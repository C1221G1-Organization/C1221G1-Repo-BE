package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService {
    Page<Prescription> findAll(String id, String name, String target, String symptom, Pageable pageable);

    void save(Prescription prescription);

    Prescription findById(String id);

    void deleteById(String id);

    void edit(Prescription prescription);
}
