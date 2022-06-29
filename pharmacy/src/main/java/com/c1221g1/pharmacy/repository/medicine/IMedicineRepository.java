package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    @Modifying
    @Query(value =
            "insert into medicine" +
                    "(medicine_id, medicine_name, medicine_active_ingredients, medicine_import_price, medicine_discount," +
                    " medicine_wholesale_profit, medicine_retail_sale_profit, medicine_tax, medicine_conversion_rate, " +
                    "medicine_manufacture,medicine_usage, medicine_instruction, medicine_age_approved, medicine_image, " +
                    "medicine_description,flag,medicine_origin_id,medicine_type_id,medicine_unit_id,medicine_conversion_unit_id)" +
                    " values" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            , nativeQuery = true)
    void createMedicine(
            @Param("id") String id, @Param("name") String name, @Param("activeIngredients") String activeIngredients,
            @Param("importPrice") Double importPrice, @Param("discount") Double discount, @Param("wholesaleProfit") Double wholesaleProfit,
            @Param("retailSaleProfit") Double retailSaleProfit, @Param("tax") Double tax, @Param("conversionRate") Double conversionRate,
            @Param("manufacture") String manufacture, @Param("usage") String usage,@Param("instruction") String instruction,
            @Param("ageApproved") String ageApproved,@Param("image") String image,@Param("description") String description,
            @Param("flag") Boolean flag,@Param("originId") Integer originId,@Param("typeId") String typeId,
            @Param("unitId") Integer unitId,@Param("conversionUnitId") Integer conversionUnitId);
}
