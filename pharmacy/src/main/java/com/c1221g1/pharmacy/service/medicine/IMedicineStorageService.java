package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;

import java.util.List;
import java.util.Optional;

public interface IMedicineStorageService {

    boolean checkExistInMedicineStorage(String medicineId);

    Long checkMedicineQuantity(String medicineId);

    boolean changeMedicineQuantity(String medicineId,Long quantity, int manipulation);

    Optional<MedicineStorage> getStorageByIdMedicine(String id);

    void updateMedicineQuantity(MedicineStorage storage);

    List<MedicineStorage> getAll();

}
