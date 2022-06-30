package com.c1221g1.pharmacy.entity.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"medicineList"})
public class MedicineType {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "LT"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String medicineTypeId;
    private String medicineTypeName;
    @JsonBackReference(value = "medicineList")
    @OneToMany(mappedBy = "medicineType")
    private List<Medicine> medicineList;

    @Override
    public String toString() {
        return "MedicineType{" +
                "medicineTypeId='" + medicineTypeId + '\'' +
                ", medicineTypeName='" + medicineTypeName + '\'' +
                '}';
    }
}
