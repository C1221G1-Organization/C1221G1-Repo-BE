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
    public Optional<MedicineStorage> getStorageByIdMedicine(Integer id) {
        return this.iMedicineStorageRepository.findById(id);
    }
    /*
     * Created by DaLQA
     * Time: 11:49 AM 30/06/2022
     * Function: function updateMedicineQuantity
     * */
    @Override
    public void updateMedicineQuantity(MedicineStorage storage) {
        this.iMedicineStorageRepository.updateMedicineQuantity(storage.getMedicineQuantity(),storage.getMedicineStorageId());
    }
//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: check storage has contained medicine.
//     * return true if exist
//     * return false if not exist
//     *
//     * @param medicineId
//     */
//    @Override
//    public boolean checkExistInMedicineStorage(String medicineId) {
//        MedicineStorage medicineStorage = this.iMedicineStorageRepository.findMedicineStorageById(medicineId);
//        return medicineStorage != null;
//    }

//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: check quantity of medicine in storage.
//     * return medicine quantity in storage
//     *
//     * @param medicineId
//     */
//    @Override
//    public Long checkMedicineQuantity(String medicineId) {
//        Long medicineQuantity = this.iMedicineStorageRepository.getMedicineQuantityByMedicineId(medicineId);
//        if (medicineQuantity == null) {
//            return 0L;
//        } else {
//            return medicineQuantity;
//        }
//    }

//    /**
//     * Created by: TrungTVH
//     * Date created: 30/6/2022
//     * function: import/export medicine in storage.
//     * manipulation: meaning "thao tac"
//     *  0. -> export
//     *  1. -> import
//     *
//     * return false if import/export fail
//     * return true if import/export success
//     *
//     * @param medicineId
//     */
//    @Override
//    public boolean changeMedicineQuantity(String medicineId, Long quantity, int manipulation) {
//        boolean checkExist = this.checkExistInMedicineStorage(medicineId);
//        Long medicineQuantity = this.checkMedicineQuantity(medicineId);
//        switch (manipulation) {
//            case 0:
//                if ((checkExist) | (medicineQuantity < quantity)) {
//                    return false;
//                } else {
//                    medicineQuantity -= quantity;
//                    this.iMedicineStorageRepository.changeMedicineQuantity(medicineId, medicineQuantity);
//                    return true;
//                }
//            case 1:
//                if (!checkExist) {
//                    MedicineStorage medicineStorage = new MedicineStorage();
//                    medicineStorage.setMedicineQuantity(quantity);
//                    this.iMedicineStorageRepository.save(medicineStorage);
//                    return true;
//                } else {
//                    medicineQuantity += quantity;
//                    this.iMedicineStorageRepository.changeMedicineQuantity(medicineId, medicineQuantity);
//                    return true;
//                }
//            default:
//                return false;
//        }
//    }



}