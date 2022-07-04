package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import java.util.Optional;

public interface IMedicineService {

    Optional<Medicine> findMedicineById(String id);

}