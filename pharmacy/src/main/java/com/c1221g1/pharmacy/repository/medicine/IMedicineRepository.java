package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicineRepository extends JpaRepository<Medicine,String> {
}
