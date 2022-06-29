package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository medicineRepository;


    /*
         Created by AnP
         Time: 17:30 29/06/2022
         Function: Get list 10 medicines best seller,
    */

    @Override
    public List<IMedicineDto> getListMedicineBestSeller() {
        return medicineRepository.getListMedicineBestSeller();
    }

    /*
        Created by AnP
        Time: 17:30 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */

    @Override
    public Page<IMedicineDto> getListAndSearch(Pageable pageable, String name, Integer typeId) {
        if (typeId !=null){
            return medicineRepository.getAllMedicineByNameAndTypeId(pageable, name, typeId);
        }
        return medicineRepository.getAllMedicineByName(pageable,name);
    }
}
