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


    @Override
    public MedicineDetailDto getMedicineDetailDtoById(String id) {
        return iMedicineRepository.getMedicineDetailDtoById(id).orElse(null);
    }

    @Override
    public List<MedicineDetailDto> get5RelativeMedicinesOf(String id) {
        return null;
    }
}
