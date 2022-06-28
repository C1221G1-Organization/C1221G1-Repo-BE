package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class ImportInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer importInvoiceId;
    private Integer importSystemCode;
    private Integer accountingVoucherNumber;
    @Column(columnDefinition = "DATE")
    private String importInvoiceDate;
    @Column(columnDefinition = "BIT")
    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @OneToMany(mappedBy = "importInvoice")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;

    public ImportInvoice() {
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
