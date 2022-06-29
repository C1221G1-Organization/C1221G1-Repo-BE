package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine,String> {
      /*
    Created by AnP
    Time: 15:00 29/06/2022
    Function: Get list 10 medicines best seller,
    */
    @Query(value="select medicine_name,\n" +
            "       medicine_retail_sale_profit * medicine_import_price as retail_price,\n" +
            "       medicine_image,\n" +
            "       sum(cart_detail_quantity) + sum(invoice_medicine_quantity) as total_quantity\n" +
            "from medicine\n" +
            "         inner join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id\n" +
            "         inner join cart_detail on medicine.medicine_id = cart_detail.medicine_id\n" +
            "        inner join cart c on cart_detail.cart_id = c.cart_id\n" +
            "where c.cart_status = 1\n" +
            "group by medicine.medicine_id\n" +
            "order by total_quantity desc\n" +
            "limit 10",
    countQuery = "select medicine_name,\n" +
            "       medicine_retail_sale_profit * medicine_import_price as retail_price,\n" +
            "       medicine_image,\n" +
            "       sum(cart_detail_quantity) + sum(invoice_medicine_quantity) as total_quantity\n" +
            "from medicine\n" +
            "         inner join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id\n" +
            "         inner join cart_detail on medicine.medicine_id = cart_detail.medicine_id\n" +
            "        inner join cart c on cart_detail.cart_id = c.cart_id\n" +
            "where c.cart_status = 1\n" +
            "group by medicine.medicine_id\n" +
            "order by total_quantity desc\n" +
            "limit 10",
    nativeQuery = true)
    List<MedicineDto> getListMedicineBestSeller();

        /*
    Created by AnP
    Time: 15:30 29/06/2022
    Function: Get All Medicine And Search by medicine_name and medicine_type
    */
    @Query(value="select medicine_name,\n" +
            "       medicine_retail_sale_profit * medicine_import_price as retail_price,\n" +
            "       medicine_image, medicine_type_id\n" +
            "from medicine\n" +
            "where `medicine_name` like :name and `medicine_type_id` = :typeId",
    countQuery = "select medicine_name,\n" +
            "       medicine_retail_sale_profit * medicine_import_price as retail_price,\n" +
            "       medicine_image, medicine_type_id\n" +
            "from medicine\n" +
            "where `medicine_name` like :name and `medicine_type_id` = :typeId",
    nativeQuery=true)
    Page<MedicineDto> getListAndSearch(Pageable pageable, @Param("name") String keyWord1, @Param("typeId") String keyWord2);
}
