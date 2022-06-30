package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {
    /*
        Created by AnP
        Time: 21:00 29/06/2022
        Function: Get list 10 medicines best seller,
    */

    @Query(value =
            "select medicineId,medicineName,medicinePrice,medicineImage, sum(totalQuantity) as soldQuantity\n" +
                    "from\n" +
                    "(select m.medicine_id                                             as medicineId,\n" +
                    "       m.medicine_name                                           as medicineName,\n" +
                    "       (m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,\n" +
                    "       m.medicine_image                                          as medicineImage,\n" +
                    "       sum(cd.cart_detail_quantity) as totalQuantity\n" +
                    "from medicine m\n" +
                    "         inner join cart_detail cd on m.medicine_id = cd.medicine_id\n" +
                    "         inner join cart c on cd.cart_id = c.cart_id\n" +
                    "         inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id\n" +
                    "group by m.medicine_id\n" +
                    "union\n" +
                    "select m.medicine_id                                             as medicineId,\n" +
                    "       m.medicine_name                                           as medicineName,\n" +
                    "       (m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,\n" +
                    "       m.medicine_image                                          as medicineImage,\n" +
                    "       sum(im.invoice_medicine_quantity) as totalQuantity\n" +
                    "from medicine m\n" +
                    "         inner join invoice_medicine im on m.medicine_id = im.medicine_id\n" +
                    "         inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id\n" +
                    "group by m.medicine_id\n" +
                    ") as total\n" +
                    "group by medicineId\n" +
                    "order by soldQuantity desc\n" +
                    "limit 10;",
            nativeQuery = true)
    List<IMedicineDto> getListMedicineBestSeller();

    /*
        Created by AnP
        Time: 18:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */

    @Query(value =
            "select m.medicine_id as medicineId, m.medicine_name as medicineName,"
                    + "(m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,"
                    + "m.medicine_manufacture as medicineManufacture, "
                    + "m.medicine_image as medicineImage,"
                    + "mt.medicine_type_name as medicineTypeName "
                    + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
                    + "inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id"
                    + " where m.medicine_name like concat('%',:name,'%') and m.medicine_type_id = :typeId",
            countQuery =
                    "select m.medicine_id as medicineId, m.medicine_name as medicineName,"
                            + "(m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,"
                            + "m.medicine_manufacture as medicineManufacture, "
                            + "m.medicine_image as medicineImage,"
                            + "mt.medicine_type_name as medicineTypeName "
                            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
                            + "inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id"
                            + " where m.medicine_name like concat('%',:name,'%') and m.medicine_type_id = :typeId",
            nativeQuery = true)
    Page<IMedicineDto> getAllMedicineByNameAndTypeId(Pageable pageable, @Param("name") String name, @Param("typeId") Integer typeId);

    /*
        Created by AnP
        Time: 18:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name
    */

    @Query(value =
            "select m.medicine_id as medicineId, m.medicine_name as medicineName,"
                    + "(m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,"
                    + "m.medicine_manufacture as medicineManufacture, "
                    + "m.medicine_image as medicineImage,"
                    + "mt.medicine_type_name as medicineTypeName "
                    + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
                    + "inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id"
                    + " where m.medicine_name like concat('%',:name,'%')",
            countQuery =
                    "select m.medicine_id as medicineId, m.medicine_name as medicineName,"
                            + "(m.medicine_import_price * m.medicine_retail_sale_profit) as medicinePrice,"
                            + "m.medicine_manufacture as medicineManufacture, "
                            + "m.medicine_image as medicineImage,"
                            + "mt.medicine_type_name as medicineTypeName "
                            + "from medicine m inner join medicine_origin mo on m.medicine_origin_id = mo.medicine_origin_id "
                            + "inner join medicine_type mt on m.medicine_type_id = mt.medicine_type_id"
                            + " where m.medicine_name like concat('%',:name,'%')",
            nativeQuery = true)
    Page<IMedicineDto> getAllMedicineByName(Pageable pageable, @Param("name") String name);
}
