package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import java.util.List;

public class MedicineUnitDto {
    private Integer medicineUnitId;
    private String medicineUnitName;
    private List<Medicine> medicineList;

    public MedicineUnitDto() {
    }

    public Integer getMedicineUnitId() {
        return medicineUnitId;
    }

    public void setMedicineUnitId(Integer medicineUnitId) {
        this.medicineUnitId = medicineUnitId;
    }

    public String getMedicineUnitName() {
        return medicineUnitName;
    }

    public void setMedicineUnitName(String medicineUnitName) {
        this.medicineUnitName = medicineUnitName;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}
