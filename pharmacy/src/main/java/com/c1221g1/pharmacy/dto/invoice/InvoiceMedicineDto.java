package com.c1221g1.pharmacy.dto.invoice;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.medicine.Medicine;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.util.List;
/*
 * Created by DaLQA
 * Time: 7:30 PM 29/06/2022
 * Function: remove properties
 * */

public class InvoiceMedicineDto {
    private Integer invoiceMedicineId;
    private Integer invoiceMedicineQuantity;
    private InvoiceDto invoice;
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

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}