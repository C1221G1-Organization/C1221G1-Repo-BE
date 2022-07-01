package com.c1221g1.pharmacy.dto.medicine;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineLookUpDto {

    private String medicineId;
    private Double medicineImportPrice;
    private Double wholesalePrice;
    private Double retailPrice;
    private Double medicineWholesaleProfit;
    private Double medicineRetailSaleProfit;
    private Double medicineConversionRate;
    private boolean flag;
    private String medicineTypeName;
    private Integer medicineUnitId;
    private Integer medicineConversionUnitId;
}
