package com.c1221g1.pharmacy.dto.medicine;

import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;

import java.util.List;

public class MedicineDto {
    private String medicineId;
    private String medicineName;
    private String medicineActiveIngredients;
    private Integer medicineQuantity;
    private Double medicineImportPrice;
    private Double medicineWholesalePrice;
    private Double medicineRetailPrice;
    private Double medicineDiscount;
    private Double medicineWholesaleProfit;
    private Double medicineRetailSaleProfit;
    private Double medicineTax;
    private boolean flag;
    private MedicineType medicineType;
    private MedicineUnit medicineUnit;
    private MedicineConversionUnit medicineConversionUnit;
    private List<MedicinePrescription> medicinePrescriptionList;
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;
    private List<InvoiceMedicine> invoiceMedicineList;
    private List<CartDetail> cartDetailList;

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

    public Double getMedicineWholesalePrice() {
        return medicineWholesalePrice;
    }

    public void setMedicineWholesalePrice(Double medicineWholesalePrice) {
        this.medicineWholesalePrice = medicineWholesalePrice;
    }

    public Double getMedicineRetailPrice() {
        return medicineRetailPrice;
    }

    public void setMedicineRetailPrice(Double medicineRetailPrice) {
        this.medicineRetailPrice = medicineRetailPrice;
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
