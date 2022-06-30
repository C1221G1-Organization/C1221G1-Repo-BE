package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Query(value =
        "select m.medicine_id as medicineId, m.medicine_name as medicineName, m.medicine_active_ingredients as medicineActiveIngredients, m.medicine_import_price as medicineImportPrice, m.medicine_retail_sale_profit as medicineRetailSaleProfit, m.medicine_manufacture as medicineManufacture, "
            + "m.medicine_usage as medicineUsage, m.medicine_instruction as medicineInstruction, m.medicine_age_approved as medicineAgeApproved, m.medicine_image as medicineImage, m.medicine_description as medicineDescription "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.medicine_id = :medicineId", nativeQuery = true)
    Optional<MedicineDetailDto> getMedicineDetailDtoById(@Param("medicineId") String medicineId);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @Query(value =
        "select m.medicine_id as medicineId, m.medicine_name as medicineName, m.medicine_active_ingredients as medicineActiveIngredients, m.medicine_import_price as medicineImportPrice, m.medicine_retail_sale_profit as medicineRetailSaleProfit, m.medicine_manufacture as medicineManufacture, "
            + "m.medicine_usage as medicineUsage, m.medicine_instruction as medicineInstruction, m.medicine_age_approved as medicineAgeApproved, m.medicine_image as medicineImage, m.medicine_description as medicineDescription "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.medicine_type_id = :medicineTypeId AND m.medicine_id != :medicineId", nativeQuery = true)
    List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId, Integer medicineTypeId);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return Integer: medicineTypeId of that medicine
     */
    @Query(value = "select m.medicine_type_id from medicine m where m.medicine_id = :medicineId", nativeQuery = true)
    Integer findMedicineTypeById(String medicineId);
}
