package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Override
    public List<MedicineSale> getListMedicineSale() {
        return this.iMedicineRepository.getListMedicineSale();

    }
}
