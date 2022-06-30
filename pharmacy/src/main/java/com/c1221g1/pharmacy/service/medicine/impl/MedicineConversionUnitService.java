package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.repository.medicine.IMedicineConversionUnitRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineConversionUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineConversionUnitService implements IMedicineConversionUnitService {
    @Autowired
    private IMedicineConversionUnitRepository medicineConversionUnitRepository;

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all list MedicineConversionUnit
     */
    @Override
    public List<MedicineConversionUnit> getAllMedicineConversionUnit() {
        return medicineConversionUnitRepository.getAllMedicineConversionUnit();
    }
}
