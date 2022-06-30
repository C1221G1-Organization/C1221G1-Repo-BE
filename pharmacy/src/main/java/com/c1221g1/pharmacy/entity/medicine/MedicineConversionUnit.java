package com.c1221g1.pharmacy.entity.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("medicineList")
public class MedicineConversionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineConversionUnitId;
    private String medicineConversionUnitName;
    @JsonBackReference(value = "medicineList")
    @OneToMany(mappedBy = "medicineConversionUnit")
    private List<Medicine> medicineList;

    @Override
    public String toString() {
        return "MedicineConversionUnit{" +
                "medicineConversionUnitId=" + medicineConversionUnitId +
                ", medicineConversionUnitName='" + medicineConversionUnitName + '\'' +
                '}';
    }
}
