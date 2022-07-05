package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.dto.prescription.MedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;

public interface IMedicinePrescriptionService {
//    boolean savePrescriptionAndMedicinePrescription(PrescriptionDto prescriptionDto);
    void saveMedicinePrescription(MedicinePrescription medicinePrescription);
}
