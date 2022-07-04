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
    private Integer quantity;
    private String medicineId;

    public InvoiceMedicineDto() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
}