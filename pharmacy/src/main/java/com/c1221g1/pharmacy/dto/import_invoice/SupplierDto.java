package com.c1221g1.pharmacy.dto.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;

import java.util.List;

public class SupplierDto {
    private String supplierId;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private String supplierEmail;
    private String note;
    private boolean flag;
//    private List<ImportInvoice> importInvoiceList;

    public SupplierDto() {
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

//    public List<ImportInvoice> getImportInvoiceList() {
//        return importInvoiceList;
//    }
//
//    public void setImportInvoiceList(List<ImportInvoice> importInvoiceList) {
//        this.importInvoiceList = importInvoiceList;
//    }
}

