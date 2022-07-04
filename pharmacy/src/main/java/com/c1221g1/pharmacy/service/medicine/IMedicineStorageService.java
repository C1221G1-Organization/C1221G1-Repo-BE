package com.c1221g1.pharmacy.service.medicine;

public interface IMedicineStorageService {

    boolean checkExistInMedicineStorage(String medicineId);

    Long checkMedicineQuantity(String medicineId);

    boolean changeMedicineQuantity(String medicineId,Long quantity, int manipulation);



}
