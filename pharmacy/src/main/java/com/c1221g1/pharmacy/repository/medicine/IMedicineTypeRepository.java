package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicineTypeRepository extends JpaRepository<MedicineType,Integer> {
}
