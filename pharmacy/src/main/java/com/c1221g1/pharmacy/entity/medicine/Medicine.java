package com.c1221g1.pharmacy.entity.medicine;

import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"medicinePrescriptionList","importInvoiceMedicineList","invoiceMedicineList","cartDetailList"})
public class Medicine {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "TH"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String medicineId;
    private String medicineName;
    private String medicineActiveIngredients;
    private Integer medicineQuantity;
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
    @OneToMany(mappedBy = "medicine")
    private List<MedicinePrescription> medicinePrescriptionList;
    @OneToMany(mappedBy = "medicine")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;
    @OneToMany(mappedBy = "medicine")
    private List<InvoiceMedicine> invoiceMedicineList;
    @OneToMany(mappedBy = "medicine")
    private List<CartDetail> cartDetailList;

    public Medicine() {
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineActiveIngredients() {
        return medicineActiveIngredients;
    }

    public void setMedicineActiveIngredients(String medicineActiveIngredients) {
        this.medicineActiveIngredients = medicineActiveIngredients;
    }

    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public Double getMedicineImportPrice() {
        return medicineImportPrice;
    }

    public void setMedicineImportPrice(Double medicineImportPrice) {
        this.medicineImportPrice = medicineImportPrice;
    }

    public Double getMedicineDiscount() {
        return medicineDiscount;
    }

    public void setMedicineDiscount(Double medicineDiscount) {
        this.medicineDiscount = medicineDiscount;
    }

    public Double getMedicineWholesaleProfit() {
        return medicineWholesaleProfit;
    }

    public void setMedicineWholesaleProfit(Double medicineWholesaleProfit) {
        this.medicineWholesaleProfit = medicineWholesaleProfit;
    }

    public Double getMedicineRetailSaleProfit() {
        return medicineRetailSaleProfit;
    }

    public void setMedicineRetailSaleProfit(Double medicineRetailSaleProfit) {
        this.medicineRetailSaleProfit = medicineRetailSaleProfit;
    }

    public Double getMedicineTax() {
        return medicineTax;
    }

    public void setMedicineTax(Double medicineTax) {
        this.medicineTax = medicineTax;
    }

    public Double getMedicineConversionRate() {
        return medicineConversionRate;
    }

    public void setMedicineConversionRate(Double medicineConversionRate) {
        this.medicineConversionRate = medicineConversionRate;
    }

    public String getMedicineManufacture() {
        return medicineManufacture;
    }

    public void setMedicineManufacture(String medicineManufacture) {
        this.medicineManufacture = medicineManufacture;
    }

    public String getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(String medicineUsage) {
        this.medicineUsage = medicineUsage;
    }

    public String getMedicineInstruction() {
        return medicineInstruction;
    }

    public void setMedicineInstruction(String medicineInstruction) {
        this.medicineInstruction = medicineInstruction;
    }

    public String getMedicineAgeApproved() {
        return medicineAgeApproved;
    }

    public void setMedicineAgeApproved(String medicineAgeApproved) {
        this.medicineAgeApproved = medicineAgeApproved;
    }

    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MedicineOrigin getMedicineOrigin() {
        return medicineOrigin;
    }

    public void setMedicineOrigin(MedicineOrigin medicineOrigin) {
        this.medicineOrigin = medicineOrigin;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }

    public MedicineUnit getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(MedicineUnit medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public MedicineConversionUnit getMedicineConversionUnit() {
        return medicineConversionUnit;
    }

    public void setMedicineConversionUnit(MedicineConversionUnit medicineConversionUnit) {
        this.medicineConversionUnit = medicineConversionUnit;
    }

    public List<MedicinePrescription> getMedicinePrescriptionList() {
        return medicinePrescriptionList;
    }

    public void setMedicinePrescriptionList(List<MedicinePrescription> medicinePrescriptionList) {
        this.medicinePrescriptionList = medicinePrescriptionList;
    }

    public List<ImportInvoiceMedicine> getImportInvoiceMedicineList() {
        return importInvoiceMedicineList;
    }

    public void setImportInvoiceMedicineList(List<ImportInvoiceMedicine> importInvoiceMedicineList) {
        this.importInvoiceMedicineList = importInvoiceMedicineList;
    }

    public List<InvoiceMedicine> getInvoiceMedicineList() {
        return invoiceMedicineList;
    }

    public void setInvoiceMedicineList(List<InvoiceMedicine> invoiceMedicineList) {
        this.invoiceMedicineList = invoiceMedicineList;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }
}
