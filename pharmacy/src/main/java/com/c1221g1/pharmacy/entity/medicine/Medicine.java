package com.c1221g1.pharmacy.entity.medicine;

import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "T"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String medicineId;
    private String medicineName;
    private String medicineActiveIngredients;
    private Double medicineImportPrice;
    private Double medicineDiscount;
    private Double medicineWholesaleProfit;
    private Double medicineRetailSaleProfit;
    private Double medicineTax;
    private Double medicineConversionRate;
    private String medicineManufacture;
    @Column(columnDefinition = "LONGTEXT")
    private String medicineUsage;
    @Column(columnDefinition = "LONGTEXT")
    private String medicineInstruction;
    private String medicineAgeApproved;
    @Column(columnDefinition = "LONGTEXT")
    private String medicineImage;
    @Column(columnDefinition = "LONGTEXT")
    private String medicineDescription;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "medicine_origin_id",referencedColumnName = "medicineOriginId")
    private MedicineOrigin medicineOrigin;
    @ManyToOne
    @JoinColumn(name = "medicine_type_id",referencedColumnName = "medicineTypeId")
    private MedicineType medicineType;
    @ManyToOne
    @JoinColumn (name = "medicine_unit_id",referencedColumnName = "medicineUnitId")
    private MedicineUnit medicineUnit;
    @ManyToOne
    @JoinColumn (name = "medicine_conversion_unit_id",referencedColumnName = "medicineConversionUnitId")
    private MedicineConversionUnit medicineConversionUnit;

    @JsonBackReference(value = "medicinePrescriptionList")
    @OneToMany(mappedBy = "medicine")
    private List<MedicinePrescription> medicinePrescriptionList;

    @JsonBackReference(value = "importInvoiceMedicineList")
    @OneToMany(mappedBy = "medicine")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;

    @JsonBackReference(value = "invoiceMedicineList")
    @OneToMany(mappedBy = "medicine")
    private List<InvoiceMedicine> invoiceMedicineList;

    @JsonBackReference(value = "cartDetailList")
    @OneToMany(mappedBy = "medicine")
    private List<CartDetail> cartDetailList;

    @JsonBackReference(value = "medicineStorageSet")
    @OneToMany(mappedBy = "medicine")
    private Set<MedicineStorage> medicineStorageSet;
}