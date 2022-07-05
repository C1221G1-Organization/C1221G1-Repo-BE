package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import com.c1221g1.pharmacy.util.VieRegex;

import javax.validation.constraints.*;
public class MedicineDto {
    private String medicineId;
    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineName;

    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineActiveIngredients;
    @NotNull
    @Positive
    private Double medicineImportPrice;

    @NotNull
    @Positive
    @Max(100)
    private Double medicineDiscount;

    @NotNull
    @Positive
    @Max(100)
    private Double medicineWholesaleProfit;

    @NotNull
    @Positive
    @Max(100)
    private Double medicineRetailSaleProfit;

    @NotNull
    @Positive
    @Max(100)
    private Double medicineTax;

    @NotNull
    @Positive
    @Max(100)
    private Integer medicineConversionRate;

    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineManufacture;
    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineUsage;
    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineInstruction;
    @NotEmpty
    @Pattern(regexp = VieRegex.VN_REGEX)
    private String medicineAgeApproved;
    @NotEmpty
    private String medicineImage;
    private String medicineDescription;
    private boolean flag;
    @NotNull
    private MedicineOrigin medicineOrigin;
    @NotNull
    private MedicineType medicineType;
    @NotNull
    private MedicineUnit medicineUnit;
    @NotNull
    private MedicineConversionUnit medicineConversionUnit;

    public MedicineDto() {
    }

    public MedicineDto(String medicineId,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineName,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineActiveIngredients,
                       @NotNull @Positive Double medicineImportPrice,
                       @NotNull @Positive @Max(100) Double medicineDiscount,
                       @NotNull @Positive @Max(100) Double medicineWholesaleProfit,
                       @NotNull @Positive @Max(100) Double medicineRetailSaleProfit,
                       @NotNull @Positive @Max(100) Double medicineTax,
                       @NotNull @Positive @Max(100) Integer medicineConversionRate,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineManufacture,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineUsage,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineInstruction,
                       @NotEmpty @Pattern(regexp = VieRegex.VN_REGEX) String medicineAgeApproved,
                       @NotEmpty String medicineImage,
                       String medicineDescription,
                               boolean flag,
                       @NotNull MedicineOrigin medicineOrigin,
                       @NotNull MedicineType medicineType,
                       @NotNull MedicineUnit medicineUnit,
                       @NotNull MedicineConversionUnit medicineConversionUnit) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineActiveIngredients = medicineActiveIngredients;
        this.medicineImportPrice = medicineImportPrice;
        this.medicineDiscount = medicineDiscount;
        this.medicineWholesaleProfit = medicineWholesaleProfit;
        this.medicineRetailSaleProfit = medicineRetailSaleProfit;
        this.medicineTax = medicineTax;
        this.medicineConversionRate = medicineConversionRate;
        this.medicineManufacture = medicineManufacture;
        this.medicineUsage = medicineUsage;
        this.medicineInstruction = medicineInstruction;
        this.medicineAgeApproved = medicineAgeApproved;
        this.medicineImage = medicineImage;
        this.medicineDescription = medicineDescription;
        this.flag = flag;
        this.medicineOrigin = medicineOrigin;
        this.medicineType = medicineType;
        this.medicineUnit = medicineUnit;
        this.medicineConversionUnit = medicineConversionUnit;
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

    public Integer getMedicineConversionRate() {
        return medicineConversionRate;
    }

    public void setMedicineConversionRate(Integer medicineConversionRate) {
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
