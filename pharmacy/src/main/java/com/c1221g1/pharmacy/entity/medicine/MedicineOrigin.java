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
public class MedicineOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineOriginId;
    private String medicineOriginName;

    @OneToMany(mappedBy = "medicineOrigin")
    private List<Medicine> medicineList;
}
