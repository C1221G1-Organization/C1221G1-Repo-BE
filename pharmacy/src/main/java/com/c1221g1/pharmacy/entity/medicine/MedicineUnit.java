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
@JsonIgnoreProperties({"medicineList"})
public class MedicineUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineUnitId;
    private String medicineUnitName;
    @JsonBackReference(value = "medicineList")
    @OneToMany(mappedBy = "medicineUnit")
    private List<Medicine> medicineList;

    @Override
    public String toString() {
        return "MedicineUnit{" +
                "medicineUnitId=" + medicineUnitId +
                ", medicineUnitName='" + medicineUnitName + '\'' +
                '}';
    }
}
