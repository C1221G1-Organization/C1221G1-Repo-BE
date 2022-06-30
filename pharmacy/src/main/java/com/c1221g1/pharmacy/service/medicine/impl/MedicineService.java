package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService implements IMedicineService {

    @Autowired
    private IMedicineRepository iMedicineRepository;

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Override
    public MedicineDetailDto getMedicineDetailDtoById(String medicineId) {
        return iMedicineRepository.getMedicineDetailDtoById(medicineId)
            .orElse(null);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return List<MedicineDetailDto> contains maximum of 5 medicines that same medicineType of medicine has medicineId
     */
    @Override
    public List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId) {
        Integer medicineTypeId = iMedicineRepository.findMedicineTypeById(medicineId);
        if (medicineTypeId == null) {
            return null;
        }
        return iMedicineRepository.get5RelativeMedicinesOf(medicineId, medicineTypeId);
    }

}
