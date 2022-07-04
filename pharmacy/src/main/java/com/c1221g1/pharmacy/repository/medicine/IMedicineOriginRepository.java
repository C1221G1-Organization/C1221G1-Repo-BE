package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineOriginRepository extends JpaRepository<MedicineOrigin,Integer> {
    @Query(value = "SELECT * FROM medicine_origin",nativeQuery = true)
    List<MedicineOrigin> getAll();
}
