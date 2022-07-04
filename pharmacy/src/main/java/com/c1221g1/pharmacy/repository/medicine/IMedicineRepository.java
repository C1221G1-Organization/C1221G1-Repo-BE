package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine, String> {

    @Query(value = "select  medicine_id as medicineId" +
            ", medicine_name as medicineName," +
            "((medicine_import_price + " +
            "(medicine_import_price*medicine_retail_sale_profit/100))/medicine_conversion_rate) " +
            "as retailPrice from medicine"
            , nativeQuery = true)
    List<MedicineSale> getListMedicineSale();
}
