package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineUnitRepository extends JpaRepository<MedicineUnit, Integer> {
    @Query(value = "SELECT * FROM medicine_unit", nativeQuery = true)
    List<MedicineUnit> getAll();
}
