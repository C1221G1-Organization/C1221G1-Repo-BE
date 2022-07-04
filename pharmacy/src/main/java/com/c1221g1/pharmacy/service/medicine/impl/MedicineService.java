package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
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

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: get list medicine and search
     */

    @Override
    public List<MedicineLookUpDto> findAllMedicine(String columName, String condition, String keyword) {
        return medicineRepository.getAllMedicine(columName,condition,keyword);
    }



    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: find medicine by medicineId
     */

    @Override
    public Medicine findMedicineById(String id) {

        return medicineRepository.findMedicineById(id);
    }

    /**
     * Created by MyC
     * Time: 23:00 29/06/2022
     * Function: delete medicine by medicineId
     */

    @Override
    public void deleteMedicineById(String id) {
        this.medicineRepository.deleteMedicineById(id);
    }


}
