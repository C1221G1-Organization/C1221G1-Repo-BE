package com.c1221g1.pharmacy.service.medicine;
import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.List;

public interface IMedicineService {
    List<MedicineLookUpDto> findAllMedicine(String columName, String condition,
                                            String keyword);

    void deleteMedicineById(String id);


    void createMedicine(Medicine medicine);

    Optional<Medicine> findMedicineById(String id);

    void updateMedicine(Medicine existMedicine);

    MedicineDetailDto getMedicineDetailDtoById(String medicineId);

    List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId);
    /*
        Created by AnP
        Time: 16:00 29/06/2022
        Function: Get list 10 medicines best seller
    */

    List<IMedicineDto> getListMedicineBestSeller();

    /*
        Created by AnP
        Time: 16:00 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */

    Page<IMedicineDto> getListAndSearch(Pageable pageable, String name, Integer typeId, String sort);
}
