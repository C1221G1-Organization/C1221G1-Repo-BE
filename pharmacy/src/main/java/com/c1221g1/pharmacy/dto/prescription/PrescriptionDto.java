package com.c1221g1.pharmacy.dto.prescription;

import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;

import java.util.List;

public class PrescriptionDto {
    private String prescriptionId;
    private String prescriptionName;
    private String prescriptionSymptom;
    private String prescriptionObject;
    private Integer prescriptionNumberOfDays;
    private Boolean flag;
    private List<MedicinePrescription> medicinePrescriptionList;

    public PrescriptionDto() {
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionSymptom() {
        return prescriptionSymptom;
    }

    public void setPrescriptionSymptom(String prescriptionSymptom) {
        this.prescriptionSymptom = prescriptionSymptom;
    }

    public String getPrescriptionObject() {
        return prescriptionObject;
    }

    public void setPrescriptionObject(String prescriptionObject) {
        this.prescriptionObject = prescriptionObject;
    }

    public Integer getPrescriptionNumberOfDays() {
        return prescriptionNumberOfDays;
    }

    public void setPrescriptionNumberOfDays(Integer prescriptionNumberOfDays) {
        this.prescriptionNumberOfDays = prescriptionNumberOfDays;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<MedicinePrescription> getMedicinePrescriptionList() {
        return medicinePrescriptionList;
    }

    public void setMedicinePrescriptionList(List<MedicinePrescription> medicinePrescriptionList) {
        this.medicinePrescriptionList = medicinePrescriptionList;
    }
}
