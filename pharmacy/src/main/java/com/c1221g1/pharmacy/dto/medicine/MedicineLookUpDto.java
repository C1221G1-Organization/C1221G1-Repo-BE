package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineLookUpDto {

    private String medicineId;
    private String medicineName;
    private String medicineActiveIngredients;
    private Double medicineImportPrice;
    private Double wholesalePrice;
    private Double retailPrice;
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
    private Integer medicineOriginId;
    private String medicineTypeName;
    private Integer medicineUnitId;
    private Integer medicineConversionUnitId;
}
