package com.c1221g1.pharmacy.service.prescription.impl;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.repository.prescription.IPrescriptionRepository;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService implements IPrescriptionService {
    @Autowired
    private IPrescriptionRepository prescriptionRepository;

    @Override
    public Page<Prescription> findAll(String id, String name, String target, String symptom, Pageable pageable) {
        return this.prescriptionRepository.findAll("%"+id+"%",
                "%"+ name +"%","%"+ target +"%","%"+ symptom +"%", pageable);
    }

    @Override
    public void save(Prescription prescription) {
        this.prescriptionRepository.createPrescription();
    }
}
