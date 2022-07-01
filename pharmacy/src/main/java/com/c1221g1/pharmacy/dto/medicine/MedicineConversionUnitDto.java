package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import java.util.List;

public class MedicineConversionUnitDto {
    private Integer medicineConversionUnitId;
    private String medicineConversionUnitName;

    public MedicineConversionUnitDto() {
    }

    public Integer getMedicineConversionUnitId() {
        return medicineConversionUnitId;
    }

    public void setMedicineConversionUnitId(Integer medicineConversionUnitId) {
        this.medicineConversionUnitId = medicineConversionUnitId;
    }

    public String getMedicineConversionUnitName() {
        return medicineConversionUnitName;
    }

    public void setMedicineConversionUnitName(String medicineConversionUnitName) {
        this.medicineConversionUnitName = medicineConversionUnitName;
    }

}
