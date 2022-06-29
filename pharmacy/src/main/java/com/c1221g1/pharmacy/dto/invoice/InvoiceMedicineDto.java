package com.c1221g1.pharmacy.dto.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.medicine.Medicine;


public class InvoiceMedicineDto {
    private Integer invoiceMedicineId;
    private Integer invoiceMedicineQuantity;
    private Invoice invoice;
    private Medicine medicine;

    public InvoiceMedicineDto() {
    }

    public Integer getInvoiceMedicineId() {
        return invoiceMedicineId;
    }

    public void setInvoiceMedicineId(Integer invoiceMedicineId) {
        this.invoiceMedicineId = invoiceMedicineId;
    }

    public Integer getInvoiceMedicineQuantity() {
        return invoiceMedicineQuantity;
    }

    public void setInvoiceMedicineQuantity(Integer invoiceMedicineQuantity) {
        this.invoiceMedicineQuantity = invoiceMedicineQuantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
