package com.c1221g1.pharmacy.dto.medicine;

import javax.persistence.Column;

public interface MedicineDetailDto {
    String getMedicineId();
    String getMedicineName();
    String getMedicineActiveIngredients();
    Double getMedicineImportPrice();
    Double getMedicineRetailSaleProfit();
    String getMedicineManufacture();
    String getMedicineUsage();
    String getMedicineInstruction();
    String getMedicineAgeApproved();
    String getMedicineImage();
    String getMedicineDescription();
}
