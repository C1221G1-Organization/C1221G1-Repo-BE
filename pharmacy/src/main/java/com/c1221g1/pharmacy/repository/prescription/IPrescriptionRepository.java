package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrescriptionRepository extends JpaRepository<Prescription,String> {
}
