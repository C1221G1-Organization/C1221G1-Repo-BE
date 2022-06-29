package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicineService implements IMedicineService {

    @Autowired
    private IMedicineRepository medicineRepository;
    @Override
    public Page<Medicine> findAllMedicine(Pageable pageable, String idValue, String medicineTypeValue,
                                          String medicineNameValue, String importPriceValue,
                                          String wholesalePriceValue, String retailPriceValue) {
        return medicineRepository.findAll(pageable, idValue, medicineNameValue, importPriceValue, );
    }
}
