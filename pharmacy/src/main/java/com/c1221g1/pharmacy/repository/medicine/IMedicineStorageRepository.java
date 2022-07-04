package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMedicineStorageRepository extends JpaRepository<MedicineStorage, Integer> {

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
