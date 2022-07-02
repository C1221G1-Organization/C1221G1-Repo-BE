package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.repository.medicine.IMedicineStorageRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineStorageService implements IMedicineStorageService {
    @Autowired
    private IMedicineStorageRepository iMedicineStorageRepository;
    @Override
    public Optional<MedicineStorage> getStorageByIdMedicine(String id) {
        return this.iMedicineStorageRepository.getStorageByMedicineId(id);
    }
    @Override
    public void updateMedicineQuantity(MedicineStorage storage) {
        this.iMedicineStorageRepository.updateMedicineQuantity(storage.getMedicineQuantity(),storage.getMedicineStorageId());
    }
}
