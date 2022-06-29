package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    @Query(value =
        "select m.medicine_id, m.medicine_name, m.medicine_active_ingredients, m.medicine_import_price, m.medicine_retail_sale_profit, m.medicine_manufacture, m.medicine_usage, m.medicine_instruction, m.medicine_age_approved, m.medicine_image, m.medicine_description "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.medicine_id = :id", nativeQuery = true)
    Optional<MedicineDetailDto> getMedicineDetailDtoById(@Param("id") String id);


    @Query(value =
        "select m.medicine_id, m.medicine_name, m.medicine_active_ingredients, m.medicine_import_price, m.medicine_retail_sale_profit, m.medicine_manufacture, m.medicine_usage, m.medicine_instruction, m.medicine_age_approved, m.medicine_image, m.medicine_description "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.medicine_type_id = :medicineTypeId", nativeQuery = true)
    List<MedicineDetailDto> get5RelativeMedicinesOf(Integer medicineTypeId);

    @Query(value = "select mt.medicine_type_id from medicine m inner join medicine_type mt on mt.medicine_type_id = m.medicine_type_id where m.medicine_id = :id", nativeQuery = true)
    Integer findMedicineTypeById(String id);
}
