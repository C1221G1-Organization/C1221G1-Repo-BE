package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query(value =
            "UPDATE medicine " +
                    "SET medicine_name=:#{#medicine.medicineName},medicine_active_ingredients=:#{#medicine.medicineActiveIngredients}," +
                    "medicine_import_price=:#{#medicine.medicineImportPrice},medicine_discount=:#{#medicine.medicineDiscount}," +
                    "medicine_wholesale_profit=:#{#medicine.medicineWholesaleProfit}," +
                    "medicine_retail_sale_profit=:#{#medicine.medicineRetailSaleProfit},medicine_tax=:#{#medicine.medicineTax}," +
                    "medicine_conversion_rate=:#{#medicine.medicineConversionRate},medicine_manufacture=:#{#medicine.medicineManufacture}," +
                    "medicine_usage=:#{#medicine.medicineUsage},medicine_instruction=:#{#medicine.medicineInstruction}," +
                    "medicine_age_approved=:#{#medicine.medicineAgeApproved},medicine_image=:#{#medicine.medicineImage}," +
                    "medicine_description=:#{#medicine.medicineDescription},medicine_origin_id=:#{#medicine.medicineOrigin}," +
                    "medicine_type_id=:#{#medicine.medicineType},medicine_unit_id=:#{#medicine.medicineUnit}," +
                    "medicine_conversion_unit_id=:#{#medicine.medicineConversionUnit}" +
                    " where medicine_id=:#{#medicine.medicineId}", nativeQuery = true)
    void updateMedicine(Medicine medicine);
    /**
     * this function use to find exist medicine in db if not exist return null
     *
     * @author LongNH
     * @Time 20:50 29/06/2022
     */
    @Query(value ="select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price,medicine_discount," +
            "medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate," +
            "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved," +
            "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," +
            "medicine_conversion_unit_id,flag " +
            "from medicine where flag = 1 and medicine_id =:id ",nativeQuery = true)
    Optional<Medicine> findMedicineById(@Param("id") String id);
<<<<<<< HEAD
}
=======
}
>>>>>>> 5994c8197acff693e71bb33472520fe498661423
