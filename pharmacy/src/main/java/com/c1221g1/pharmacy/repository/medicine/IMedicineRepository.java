package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {



    /**
     * Created by MyC
     * Time: 23:00 30/06/2022
     * Function: use procedure in DB search list medicine
     */
//    @Query(value = "call look_up (:columName, :condition, :keyWord)",nativeQuery = true)
//    List<MedicineLookUpDto> getAllMedicine(@Param("columName") String columName , @Param("condition") String condition,
//                                           @Param("keyWord") String keyWord);

    @Query(value = "select * from(\n" +
            "select medicine.medicine_id,\n" +
            "    medicine_name,\n" +
            "    medicine_active_ingredients,\n" +
            "    medicine_import_price,\n" +
            "(medicine_import_price + (medicine_import_price*medicine_wholesale_profit/100)) as wholesale_price,\n" +
            "((medicine_import_price + (medicine_import_price*medicine_retail_sale_profit/100))/medicine_conversion_rate) as retail_price,\n" +
            "            medicine_discount,\n" +
            "            medicine_retail_sale_profit,\n" +
            "            medicine_tax,\n" +
            "            medicine_conversion_rate,\n" +
            "            medicine_manufacture,\n" +
            "            medicine_image,\n" +
            "            medicine_description,\n" +
            "            medicine_origin_id,\n" +
            "            medicine_type.medicine_type_name,\n" +
            "            medicine_unit_id,\n" +
            "            medicine_conversion_unit_id,\n" +
            "            flag \n" +
            "            from medicine inner join medicine_type on medicine.medicine_type_id = medicine_type.medicine_type_id\n" +
            "            ) as medicine\n" +
            "            where :columName :condition  :keyWord",nativeQuery = true)
    List<MedicineLookUpDto> getAllMedicine(@Param("columName") String columName , @Param("condition") String condition,
                                           @Param("keyWord") String keyWord);
    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get list by medicineId
     */


    @Query(value = "select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price," +
            "(medicine_import_price + (medicine_import_price*medicine_wholesale_profit/100)) as wholesale_price," +
            "((medicine_import_price + (medicine_import_price*medicine_retail_sale_profit/100))/medicine_conversion_rate) as retail_price," +
            "medicine_discount,medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate," +
            "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved," +
            "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," +
            "medicine_conversion_unit_id,flag " +
            "from medicine", nativeQuery = true)
    List<Medicine> getListMedicine();

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: find medicine by medicineId
     */

    @Query(value = "select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price,medicine_discount," +
            "medicine_wholesale_profit,medicine_retail_sale_profit,medicine_tax,medicine_conversion_rate," +
            "medicine_manufacture,medicine_usage,medicine_instruction,medicine_age_approved," +
            "medicine_image,medicine_description,medicine_origin_id,medicine_type_id,medicine_unit_id," +
            "medicine_conversion_unit_id,flag " +
            "from medicine where flag = 1 and medicine_id =:id ", nativeQuery = true)
    Medicine findMedicineById(String id);

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @Transactional
    @Modifying
    @Query(value = "UPDATE medicine set flag = 0 where medicine_id = :id ", nativeQuery = true)
    void deleteMedicineById(String id);
}