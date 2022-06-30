package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
