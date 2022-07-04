package com.c1221g1.pharmacy.entity.prescription;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import javax.persistence.*;

@Entity
@Table(name = "medicine_prescription", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "MEDICINE_PRESCRIPTION_UK", columnNames = {"prescription_id", "medicine_id"})})
public class MedicinePrescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicinePrescriptionId;
    private Integer medicinePrescriptionTimes;
    private Integer medicinePrescriptionNumberPerTime;
    @ManyToOne
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescriptionId",nullable = false)
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId",nullable = false)
    private Medicine medicine;

    public MedicinePrescription() {
    }

    public Integer getMedicinePrescriptionId() {
        return medicinePrescriptionId;
    }

    public void setMedicinePrescriptionId(Integer medicinePrescriptionId) {
        this.medicinePrescriptionId = medicinePrescriptionId;
    }

    public Integer getMedicinePrescriptionTimes() {
        return medicinePrescriptionTimes;
    }

    public void setMedicinePrescriptionTimes(Integer medicinePrescriptionTimes) {
        this.medicinePrescriptionTimes = medicinePrescriptionTimes;
    }

    public Integer getMedicinePrescriptionNumberPerTime() {
        return medicinePrescriptionNumberPerTime;
    }

    public void setMedicinePrescriptionNumberPerTime(Integer medicinePrescriptionNumberPerTime) {
        this.medicinePrescriptionNumberPerTime = medicinePrescriptionNumberPerTime;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}