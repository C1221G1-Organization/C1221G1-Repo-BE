package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IMedicineStorageRepository extends JpaRepository<MedicineStorage,Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE `medicine_storage` SET `medicine_quantity` = ?1 WHERE (`medicine_storage_id` = ?2) and flag = true ",nativeQuery = true)
    void updateMedicineQuantity(Long medicineQuantity, Integer medicineStorageId);



    @Query(value = "select medicine_storage_id, flag, medicine_quantity, medicine_id " +
            "from medicine_storage " +
            "where medicine_id = :medicine_id and flag = true ",
            nativeQuery = true)
    Optional<MedicineStorage> getStorageByMedicineId(@Param("medicine_id") String id);

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: finding medicine storage object by medicine id
     *
     * @param medicineId
     * @return medicineStorage object
     */
    @Query(value = "SELECT medicine_storage_id, medicine_id , medicine_quantity " +
            "FROM medicine_storage " +
            "WHERE medicine_id = :id AND flag = 1", nativeQuery = true)
    MedicineStorage findMedicineStorageById(@Param("id") String medicineId);

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: get medicine quantity in storage.
     *
     * @param medicineId
     * @return medicine quantity
     */
    @Query(value = "SELECT  medicine_quantity " +
            "FROM medicine_storage " +
            "WHERE medicine_id = :id AND flag = 1", nativeQuery = true)
    Long getMedicineQuantityByMedicineId(@Param("id") String medicineId);


    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: decrease quantity of medicine by medicine for export storage medince
     *
     * @param medicineId
     * @param quantity
     * @return void
     */
    @Query("update MedicineStorage ms set ms.medicineQuantity = :quantity " +
            "where ms.medicine.medicineId = :medicine_id")
    void changeMedicineQuantity(@Param("medicine_id") String medicineId, @Param("quantity") Long quantity);
}
