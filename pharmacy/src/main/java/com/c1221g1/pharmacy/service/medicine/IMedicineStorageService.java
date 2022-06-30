package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineStorageDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import org.springframework.validation.BindingResult;

public interface IMedicineStorageService {
    void checkExistInMedicineStorage(MedicineStorageDto medicineStorageDto, BindingResult bindingResult);
    void updateStorageMedicineByMedicineId(Medicine medicine, Long medicineQuantity);
    void addMedicineStorage(MedicineStorage medicineStorage);


    boolean checkExistInMedicineStorage(String medicineId);

    Long checkMedicineQuantity(String medicineId);

    boolean changeMedicineQuantity(String medicineId,Long quantity, int manipulation);



}
