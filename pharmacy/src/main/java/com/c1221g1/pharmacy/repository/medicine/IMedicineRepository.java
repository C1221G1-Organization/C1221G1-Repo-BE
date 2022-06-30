package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {


//    @Query(value = "select employee.id as id, employee_name as name, date_of_birth as dateOfBirth," +
//            " address as address, phone_number as phoneNumber ,position.id as idPosition," +
//            " position.position_name as namePosition" +
//            " from employee join position on employee.position_id = position.id" +
//            " where delete_flag = 0 and employee_name like concat('%', :name ,'%') "
//            ,
//            countQuery = "select employee.id as id, employee_name as name, date_of_birth as dateOfBirth," +
//                    " address as address, phone_number as phoneNumber ,position.id as idPosition," +
//                    " position.position_name as namePosition" +
//                    " from employee join position on employee.position_id = position.id" +
//                    " where delete_flag = 0 and employee_name like concat('%', :name ,'%') ",
//            nativeQuery = true)
//    Page<Medicine> pageFindAll(Pageable pageable, String idValue, String medicineTypeValue,
//                               String medicineNameValue, String medicineActiveIngredientsValue,
//                               String importPriceValue, String wholesalePriceValue, String retailPriceValue);
//};
    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get list by medicineId
     */


    @Query(value = "select medicine_id,medicine_name,medicine_active_ingredients,medicine_import_price," +
            "sum(medicine_import_price + (medicine_import_price*medicine_wholesale_profit/100)) as wholesale_price," +
            "sum(medicine_import_price + (medicine_import_price*medicine_retail_sale_profit/100)) as retail_price," +
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