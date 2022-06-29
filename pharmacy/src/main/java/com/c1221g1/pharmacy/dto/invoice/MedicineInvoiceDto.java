package com.c1221g1.pharmacy.dto.invoice;

/*
 * Created by DaLQA
 * Time: 7:30 PM 29/06/2022
 * Function: create MedicineInvoiceDto
 * */
public class MedicineInvoiceDto {
    private Integer id;
    private Integer quantity;
    private String medicineName;
    private Double price;
    private Integer unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
