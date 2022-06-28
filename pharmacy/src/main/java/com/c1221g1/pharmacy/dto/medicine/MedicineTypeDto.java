package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import java.util.List;

public class MedicineTypeDto {
    private String medicineTypeId;
    private String medicineTypeName;
    private List<Medicine> medicineList;

    public MedicineTypeDto() {
    }

    public String getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(String medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }
}
