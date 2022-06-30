package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDto {
    private String medicineId;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9 ]+$")
    @Length(min = 3, max = 50)
    private String medicineName;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9 ]+$")
    @Length(min = 3, max = 50)
    private String medicineActiveIngredients;

    @NotNull
    @Positive
    @Max(999999999)
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
    private Double medicineConversionRate;

    @NotEmpty
    @Length(min = 2, max = 50)
    private String medicineManufacture;
    @NotEmpty
    @Length(min = 2, max = 50)
    private String medicineUsage;
    @NotEmpty
    @Length(min = 2, max = 50)
    private String medicineInstruction;
    @NotEmpty
    @Length(min = 2, max = 50)
    private String medicineAgeApproved;
    @NotEmpty
    @Length(min = 2, max = 50)
    private String medicineImage;
    @NotEmpty
    @Length(min = 2, max = 50)
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
}
