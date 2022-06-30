package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import java.util.List;

public interface IMedicineService {

    MedicineDetailDto getMedicineDetailDtoById(String medicineId);

    List<MedicineDetailDto> get5RelativeMedicinesOf(String medicineId);
}
