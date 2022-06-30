package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import com.c1221g1.pharmacy.repository.medicine.IMedicineUnitRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineUnitService implements IMedicineUnitService {


    @Autowired
    private IMedicineUnitRepository medicineUnitRepository;

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all list MedicineUnit
     */

    @Override
    public List<MedicineUnit> getAllMedicineUnit() {
        return medicineUnitRepository.getAllMedicineUnit();
    }
}
