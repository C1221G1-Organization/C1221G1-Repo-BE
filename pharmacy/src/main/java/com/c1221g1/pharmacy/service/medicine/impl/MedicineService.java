package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository medicineRepository;

    /**
     * this function use to create new medicine
     *
     * @author LongNH
     * @Time 15:30 29/06/2022
     */
    @Override
    public void createMedicine(Medicine medicine) {
        medicine.setFlag(true);
        this.medicineRepository.save(medicine);
    }

    /**
     * this function use to find medicine in db and return medicine
     *
     * @author LongNH
     * @Time 20:20 29/06/2022
     */
    @Override
    public Optional<Medicine> findMedicineById(String id) {
        return this.medicineRepository.findMedicineById(id);
    }

    /**
     * this function use to create exist medicine
     *
     * @author LongNH
     * @Time 20:10 29/06/2022
     */
    @Override
    public void updateMedicine(Medicine existMedicine) {
        this.medicineRepository.updateMedicine(existMedicine);
    }

    /**
     * Creator: NghiaNTT Time: 29/02/2022
     *
     * @param medicineId: String
     * @return MedicineDetailDto contain properties to show customers
     */
    @Override
    public MedicineDetailDto getMedicineDetailDtoById(String medicineId) {
        return medicineRepository.getMedicineDetailDtoById(medicineId)
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
        Integer medicineTypeId = medicineRepository.findMedicineTypeById(medicineId);
        if (medicineTypeId == null) {
            return null;
        }
        return medicineRepository.get5RelativeMedicinesOf(medicineId, medicineTypeId);
    }
}

