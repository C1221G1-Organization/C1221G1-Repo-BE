package com.c1221g1.pharmacy.dto.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.import_invoice.Payment;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;

import java.util.List;

public class ImportInvoiceDto {
    private Integer importInvoiceId;
    private Integer importSystemCode;
    private Integer accountingVoucherNumber;
    private String importInvoiceDate;
    private boolean flag;
    private Payment payment;
    private Supplier supplier;
    private Employee employee;
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;

    public ImportInvoiceDto() {
    }

    public Integer getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(Integer importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public Integer getImportSystemCode() {
        return importSystemCode;
    }

    public void setImportSystemCode(Integer importSystemCode) {
        this.importSystemCode = importSystemCode;
    }

    public Integer getAccountingVoucherNumber() {
        return accountingVoucherNumber;
    }

    public void setAccountingVoucherNumber(Integer accountingVoucherNumber) {
        this.accountingVoucherNumber = accountingVoucherNumber;
    }

    public String getImportInvoiceDate() {
        return importInvoiceDate;
    }

    public void setImportInvoiceDate(String importInvoiceDate) {
        this.importInvoiceDate = importInvoiceDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ImportInvoiceMedicine> getImportInvoiceMedicineList() {
        return importInvoiceMedicineList;
    }

    public void setImportInvoiceMedicineList(List<ImportInvoiceMedicine> importInvoiceMedicineList) {
        this.importInvoiceMedicineList = importInvoiceMedicineList;
    }
}
