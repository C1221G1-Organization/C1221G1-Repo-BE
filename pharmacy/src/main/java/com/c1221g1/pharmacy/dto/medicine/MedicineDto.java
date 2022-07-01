package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class MedicineDto {
    private String medicineId;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Length(min = 3,max = 50)
    private String medicineName;
    private String medicineActiveIngredients;
    private Double medicineImportPrice;
    private Double medicineDiscount;
    private Double medicineWholesaleProfit;
    private Double medicineRetailSaleProfit;
    private Double medicineTax;
    private Double medicineConversionRate;
    private String medicineManufacture;
    private String medicineUsage;
    private String medicineInstruction;
    private String medicineAgeApproved;
    private String medicineImage;
    private String medicineDescription;
    private boolean flag;
    private MedicineOrigin medicineOrigin;
    private MedicineType medicineType;
    private MedicineUnit medicineUnit;
    private MedicineConversionUnit medicineConversionUnit;

    public MedicineDto() {
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
}
