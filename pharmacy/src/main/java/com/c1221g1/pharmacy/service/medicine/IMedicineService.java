package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDetailDto;
import java.util.List;

public interface IMedicineService {

    MedicineDetailDto getMedicineDetailDtoById(String id);

    List<MedicineDetailDto> get5RelativeMedicinesOf(String id);
}
