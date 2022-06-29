package com.c1221g1.pharmacy.service.medicine.impl;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository medicineRepository;

    @Override
    public void createMedicine(Medicine medicine) {
        String medicineId = medicine.getMedicineId();
        String medicineName = medicine.getMedicineName();
        String medicineActiveIngredients = medicine.getMedicineActiveIngredients();
        Double medicineImportPrice = medicine.getMedicineImportPrice();
        Double medicineDiscount = medicine.getMedicineDiscount();
        Double medicineWholesaleProfit = medicine.getMedicineWholesaleProfit();
        Double medicineRetailSaleProfit = medicine.getMedicineRetailSaleProfit();
        Double medicineTax = medicine.getMedicineTax();
        Double medicineConversionRate = medicine.getMedicineConversionRate();
        String medicineManufacture = medicine.getMedicineManufacture();
        String medicineUsage = medicine.getMedicineUsage();
        String medicineInstruction = medicine.getMedicineInstruction();
        String medicineAgeApproved = medicine.getMedicineAgeApproved();
        String medicineImage = medicine.getMedicineImage();
        String medicineDescription = medicine.getMedicineDescription();
        Integer medicineOriginId = medicine.getMedicineOrigin().getMedicineOriginId();
        String medicineTypeId = medicine.getMedicineType().getMedicineTypeId();
        Integer medicineUnitId = medicine.getMedicineUnit().getMedicineUnitId();
        Integer medicineConversionUnitId = medicine.getMedicineConversionUnit().getMedicineConversionUnitId();
        this.medicineRepository.createMedicine
                (
                        medicineId, medicineName, medicineActiveIngredients, medicineImportPrice, medicineDiscount,
                        medicineWholesaleProfit, medicineRetailSaleProfit, medicineTax, medicineConversionRate,
                        medicineManufacture, medicineUsage, medicineInstruction, medicineAgeApproved, medicineImage,
                        medicineDescription, true, medicineOriginId, medicineTypeId, medicineUnitId, medicineConversionUnitId
                );
    }
}
