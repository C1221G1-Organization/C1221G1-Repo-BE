package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    @Query(value = "select  medicine_id as medicineId" +
            ", medicine_name as medicineName," +
            "((medicine_import_price + " +
            "(medicine_import_price*medicine_retail_sale_profit/100))/medicine_conversion_rate) " +
            "as retailPrice from medicine"
            , nativeQuery = true)
    List<MedicineSale> getListMedicineSale();
    /**
     * this function use to find exist medicine in db if not exist return null
     *
     * @author LongNH
     * @Time 20:50 29/06/2022
     */
    @Query(value = "select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price,medicine_discount," +
            "medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate," +
            "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved," +
            "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," +
            "medicine_conversion_unit_id,flag " +
            "from medicine where flag = 1 and medicine_id =:id ", nativeQuery = true)
    Optional<Medicine> findMedicineById(@Param("id") String id);

}
