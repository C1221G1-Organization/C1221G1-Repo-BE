package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineConversionUnitRepository extends JpaRepository<MedicineConversionUnit, Integer> {
    @Query(value = "SELECT * FROM medicine_conversion_unit", nativeQuery = true)
    List<MedicineConversionUnit> getAll();
}
