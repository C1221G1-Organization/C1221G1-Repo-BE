package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicinePrescriptionRepository extends JpaRepository<MedicinePrescription,Integer> {
}
