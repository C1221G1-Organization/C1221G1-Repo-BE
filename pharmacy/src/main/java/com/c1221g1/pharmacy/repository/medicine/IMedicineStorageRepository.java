package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IMedicineStorageRepository extends JpaRepository<MedicineStorage, Integer> {

    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateQuantityMedicine
     * */
    @Query(value = "select medicine_storage_id, flag, medicine_quantity, medicine_id " +
            "from medicine_storage " +
            "where medicine_id = :medicine_id and flag = true ",
            nativeQuery = true)
    Optional<MedicineStorage> getStorageByMedicineId(@Param("medicine_id") String id);

    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateMedicineQuantity
     * */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `medicine_storage` SET `medicine_quantity` = ?1 " +
            "WHERE (`medicine_storage_id` = ?2) and flag = true ",
            nativeQuery = true)
    void updateMedicineQuantity(Long medicineQuantity, Integer medicineStorageId);



}