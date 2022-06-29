package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicineService {
    Page<Medicine> findAllMedicine(Pageable pageable, String idValue, String medicineTypeValue,
                                   String medicineNameValue,String medicineActiveIngredientsValue, String importPriceValue, String wholesalePriceValue,
                                   String retailPriceValue);
}
