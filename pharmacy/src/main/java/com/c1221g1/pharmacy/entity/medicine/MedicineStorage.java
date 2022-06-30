package com.c1221g1.pharmacy.entity.medicine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineStorageId;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
    private Long medicineQuantity;
    @Column(columnDefinition = "BIT")
    private boolean flag;
}