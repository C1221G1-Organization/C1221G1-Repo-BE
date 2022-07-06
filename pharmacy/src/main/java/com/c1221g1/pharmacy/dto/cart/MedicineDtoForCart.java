package com.c1221g1.pharmacy.dto.cart;

public class MedicineDtoForCart {
    private String medicineId;
    private String MedicineName;
    private String MedicineImage;
    private Double MedicinePrice;

    public MedicineDtoForCart() {
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public String getMedicineImage() {
        return MedicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        MedicineImage = medicineImage;
    }

    public Double getMedicinePrice() {
        return MedicinePrice;
    }

    public void setMedicinePrice(Double medicinePrice) {
        MedicinePrice = medicinePrice;
    }

    @Override
    public String toString() {
        return "MedicineDtoForCart{" +
                "medicineId='" + medicineId + '\'' +
                ", MedicineName='" + MedicineName + '\'' +
                ", MedicineImage='" + MedicineImage + '\'' +
                ", MedicinePrice=" + MedicinePrice +
                '}';
    }
}
