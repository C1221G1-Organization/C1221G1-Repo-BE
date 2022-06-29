package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineService {
    /*
  Created by AnP
  Time: 16:00 29/06/2022
  Function: Get list 10 medicines best seller,
*/
    List<MedicineDto> getListMedicineBestSeller();

    /*
Created by AnP
Time: 16:00 29/06/2022
Function: Get All Medicine And Search by medicine_name and medicine_type
*/
    Page<MedicineDto> getListAndSearch(Pageable pageable, String keyWord1, String keyWord2);

}
