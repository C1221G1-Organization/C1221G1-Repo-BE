package com.c1221g1.pharmacy.entity.medicine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineConversionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineConversionUnitId;
    private String medicineConversionUnitName;
    @OneToMany(mappedBy = "medicineConversionUnit")
    private List<Medicine> medicineList;
}
