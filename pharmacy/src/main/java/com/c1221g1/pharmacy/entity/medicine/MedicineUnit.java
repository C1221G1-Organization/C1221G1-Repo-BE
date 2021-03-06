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
public class MedicineUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineUnitId;
    private String medicineUnitName;
    @OneToMany(mappedBy = "medicineUnit")
    private List<Medicine> medicineList;
}
