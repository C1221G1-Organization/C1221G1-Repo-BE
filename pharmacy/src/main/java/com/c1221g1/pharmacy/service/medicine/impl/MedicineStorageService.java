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
    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function getStorageByMedicineId
     * */
    @Override
    public Optional<MedicineStorage> getStorageByIdMedicine(String id) {
        return this.iMedicineStorageRepository.getStorageByMedicineId(id);
    }
    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateMedicineQuantity
     * */
    @Override
    public void updateMedicineQuantity(MedicineStorage storage) {
        this.iMedicineStorageRepository.updateMedicineQuantity
                (storage.getMedicineQuantity(),storage.getMedicineStorageId());
    }

}