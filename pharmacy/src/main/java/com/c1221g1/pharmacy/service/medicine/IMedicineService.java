package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.IMedicineDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineService {
    /*
        Created by AnP
        Time: 16:00 29/06/2022
        Function: Get list 10 medicines best seller
    */

    List<IMedicineDto> getListMedicineBestSeller();

    /*
        Created by AnP
        Time: 16:00 29/06/2022
        Function: Get All Medicine And Search by medicine_name and medicine_type
    */

    Page<IMedicineDto> getListAndSearch(Pageable pageable, String name, Integer typeId);

}
