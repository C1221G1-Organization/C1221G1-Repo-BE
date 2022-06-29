package com.c1221g1.pharmacy.entity.prescription;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescriptionId")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
}
