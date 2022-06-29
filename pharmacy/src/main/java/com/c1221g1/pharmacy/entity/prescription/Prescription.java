package com.c1221g1.pharmacy.entity.prescription;

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
public class Prescription {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DT"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String prescriptionId;
    private String prescriptionName;
    @Column(columnDefinition = "LONGTEXT")
    private String prescriptionSymptom;
    private String prescriptionTargetUser;
    @Column(columnDefinition = "LONGTEXT")
    private String prescriptionNote;
    private Integer prescriptionNumberOfDays;
    private Boolean flag;
    @OneToMany(mappedBy = "prescription")
    private List<MedicinePrescription> medicinePrescriptionList;
}
