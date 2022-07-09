package com.c1221g1.pharmacy.dto.medicine;

public interface IMedicineDto {
    String getMedicineId();
    String getMedicineName();
    Double getMedicinePrice();
    Integer getMedicineQuantity();
    Integer getSoldQuantity();
    String getMedicineImage();
    String getMedicineTypeName();
}
