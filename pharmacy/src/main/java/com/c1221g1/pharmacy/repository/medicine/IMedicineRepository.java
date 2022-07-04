package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    /**
     * this function use to edit exist medicine
     *
     * @author LongNH
     * @Time 20:01 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine "
        + "SET medicine_name=:#{#medicine.medicineName},medicine_active_ingredients=:#{#medicine.medicineActiveIngredients},"
        + "medicine_import_price=:#{#medicine.medicineImportPrice},medicine_discount=:#{#medicine.medicineDiscount},"
        + "medicine_wholesale_profit=:#{#medicine.medicineWholesaleProfit},"
        + "medicine_retail_sale_profit=:#{#medicine.medicineRetailSaleProfit},medicine_tax=:#{#medicine.medicineTax},"
        + "medicine_conversion_rate=:#{#medicine.medicineConversionRate},medicine_manufacture=:#{#medicine.medicineManufacture},"
        + "medicine_usage=:#{#medicine.medicineUsage},medicine_instruction=:#{#medicine.medicineInstruction},"
        + "medicine_age_approved=:#{#medicine.medicineAgeApproved},medicine_image=:#{#medicine.medicineImage},"
        + "medicine_description=:#{#medicine.medicineDescription},medicine_origin_id=:#{#medicine.medicineOrigin},"
        + "medicine_type_id=:#{#medicine.medicineType},medicine_unit_id=:#{#medicine.medicineUnit},"
        + "medicine_conversion_unit_id=:#{#medicine.medicineConversionUnit}" + " where medicine_id=:#{#medicine.medicineId}", nativeQuery = true)
    void updateMedicine(Medicine medicine);

    /**
     * this function use to find exist medicine in db if not exist return null
     *
     * @author LongNH
     * @Time 20:50 29/06/2022
     */
    @Query(value = "select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price,medicine_discount,"
        + "medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate,"
        + "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved,"
        + "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," + "medicine_conversion_unit_id,flag "
        + "from medicine where flag = 1 and medicine_id =:id ", nativeQuery = true)
    Optional<Medicine> findMedicineById(@Param("id") String id);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Query(value =
        "select m.medicine_id as medicineId, m.medicine_name as medicineName, m.medicine_active_ingredients as medicineActiveIngredients, m.medicine_import_price * (1 + m.medicine_retail_sale_profit / 100) / m.medicine_conversion_rate as medicinePrice, m.medicine_manufacture as medicineManufacture, "
            + "m.medicine_usage as medicineUsage, m.medicine_instruction as medicineInstruction, m.medicine_age_approved as medicineAgeApproved, m.medicine_image as medicineImage, m.medicine_description as medicineDescription, mo.medicine_origin_name as medicineOrigin, "
            + "mcu.medicine_conversion_unit_name as medicineConversionUnit, ms.medicine_quantity as medicineQuantity  "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_conversion_unit mcu on m.medicine_conversion_unit_id = mcu.medicine_conversion_unit_id "
            + "inner join medicine_storage ms on m.medicine_id = ms.medicine_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.flag = 1 AND m.medicine_id = :medicineId", nativeQuery = true)
    Optional<MedicineDetailDto> getMedicineDetailDtoById(@Param("medicineId") String medicineId);

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @Query(value =
        "select m.medicine_id as medicineId, m.medicine_name as medicineName, m.medicine_active_ingredients as medicineActiveIngredients, m.medicine_import_price * (1 + m.medicine_retail_sale_profit / 100) / m.medicine_conversion_rate as medicinePrice, m.medicine_manufacture as medicineManufacture, "
            + "m.medicine_usage as medicineUsage, m.medicine_instruction as medicineInstruction, m.medicine_age_approved as medicineAgeApproved, m.medicine_image as medicineImage, m.medicine_description as medicineDescription, mo.medicine_origin_name as medicineOrigin, "
            + "mcu.medicine_conversion_unit_name as medicineConversionUnit, ms.medicine_quantity as medicineQuantity  "
            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
            + "inner join medicine_conversion_unit mcu on m.medicine_conversion_unit_id = mcu.medicine_conversion_unit_id "
            + "inner join medicine_storage ms on m.medicine_id = ms.medicine_id "
            + "inner join medicine_unit mu on m.medicine_unit_id = mu.medicine_unit_id inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id where m.flag = 1 AND m.medicine_type_id = :medicineTypeId AND m.medicine_id != :medicineId limit 5", nativeQuery = true)
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
