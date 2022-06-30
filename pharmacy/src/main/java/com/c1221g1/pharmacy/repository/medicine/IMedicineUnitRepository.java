package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineUnitRepository extends JpaRepository<MedicineUnit,Integer> {

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all list MedicineUnit
     */
    @Query(value = "select medicine_unit_id,medicine_unit_name from" +
            " medicine_unit", nativeQuery = true)
    List<MedicineUnit> getAllMedicineUnit();
}
