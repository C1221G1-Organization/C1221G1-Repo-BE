package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository medicineRepository;




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


}
