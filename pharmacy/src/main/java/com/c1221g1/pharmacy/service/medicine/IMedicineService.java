package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.invoice.MedicineSale;
import com.c1221g1.pharmacy.entity.medicine.Medicine;


import java.util.List;

public interface IMedicineService {
    List<MedicineSale> getListMedicineSale();
}
