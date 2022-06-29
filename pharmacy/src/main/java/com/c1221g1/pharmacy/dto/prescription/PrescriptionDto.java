package com.c1221g1.pharmacy.dto.prescription;

public class PrescriptionDto {
    private String prescriptionId;
    private String prescriptionName;
    private String prescriptionSymptom;
    private String prescriptionTargetUser;
    private String prescriptionNote;
    private Integer prescriptionNumberOfDays;
    private Boolean flag;

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

    public String getPrescriptionTargetUser() {
        return prescriptionTargetUser;
    }

    public void setPrescriptionTargetUser(String prescriptionTargetUser) {
        this.prescriptionTargetUser = prescriptionTargetUser;
    }

    public String getPrescriptionNote() {
        return prescriptionNote;
    }

    public void setPrescriptionNote(String prescriptionNote) {
        this.prescriptionNote = prescriptionNote;
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
}
