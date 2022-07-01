package com.c1221g1.pharmacy.dto.invoice;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;

import java.util.List;

public class InvoiceDto {
    private String invoiceId;
    private Customer customer;
    private Employee employee;
    private TypeOfInvoice typeOfInvoice;
    private String invoiceNote;
    private String invoiceCreatedDate;
    private String invoiceCreateTime;
    private boolean flag;
    private Double invoiceTotalMoney;
    private List<InvoiceMedicineDto> invoiceMedicineList;

    public InvoiceDto() {
    }

    public Double getInvoiceTotalMoney() {
        return invoiceTotalMoney;
    }

    public void setInvoiceTotalMoney(Double invoiceTotalMoney) {
        this.invoiceTotalMoney = invoiceTotalMoney;
    }

    public String getInvoiceCreateTime() {
        return invoiceCreateTime;
    }

    public void setInvoiceCreateTime(String invoiceCreateTime) {
        this.invoiceCreateTime = invoiceCreateTime;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TypeOfInvoice getTypeOfInvoice() {
        return typeOfInvoice;
    }

    public void setTypeOfInvoice(TypeOfInvoice typeOfInvoice) {
        this.typeOfInvoice = typeOfInvoice;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceCreatedDate() {
        return invoiceCreatedDate;
    }

    public void setInvoiceCreatedDate(String invoiceCreatedDate) {
        this.invoiceCreatedDate = invoiceCreatedDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<InvoiceMedicineDto> getInvoiceMedicineList() {
        return invoiceMedicineList;
    }

    public void setInvoiceMedicineList(List<InvoiceMedicineDto> invoiceMedicineList) {
        this.invoiceMedicineList = invoiceMedicineList;
    }
}
