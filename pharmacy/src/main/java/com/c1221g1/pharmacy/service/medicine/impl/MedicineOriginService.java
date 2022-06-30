package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.repository.medicine.IMedicineOriginRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineOriginService implements IMedicineOriginService {

    @Autowired
    private IMedicineOriginRepository medicineOriginRepository;

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get all list MedicineOrigin
     */
    @Override
    public List<MedicineOrigin> getAllMedicineOrigin() {
        return medicineOriginRepository.getAllMedicineOrigin();
    }
}
