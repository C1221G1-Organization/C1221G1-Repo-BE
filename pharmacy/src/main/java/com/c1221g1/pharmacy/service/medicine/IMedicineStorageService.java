package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;

import java.util.Optional;

public interface IMedicineStorageService {
    Optional<MedicineStorage> getStorageByIdMedicine(String id);

    void updateMedicineQuantity(MedicineStorage storage);
}
