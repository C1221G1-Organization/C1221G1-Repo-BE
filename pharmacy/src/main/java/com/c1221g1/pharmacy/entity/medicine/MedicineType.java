package com.c1221g1.pharmacy.entity.medicine;

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
public class MedicineType {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "LT"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String medicineTypeId;
    private String medicineTypeName;

    @OneToMany(mappedBy = "medicineType")
    private List<Medicine> medicineList;
}
