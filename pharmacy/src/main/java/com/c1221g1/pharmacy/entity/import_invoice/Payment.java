package com.c1221g1.pharmacy.entity.import_invoice;

import javax.persistence.*;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Integer paymentDiscount;
    private Double paymentPrepayment;
    @OneToMany(mappedBy = "payment")
    private List<ImportInvoice> importInvoiceList;

    public Payment() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentDiscount() {
        return paymentDiscount;
    }

    public void setPaymentDiscount(Integer paymentDiscount) {
        this.paymentDiscount = paymentDiscount;
    }

    public Double getPaymentPrepayment() {
        return paymentPrepayment;
    }

    public void setPaymentPrepayment(Double paymentPrepayment) {
        this.paymentPrepayment = paymentPrepayment;
    }

    public List<ImportInvoice> getImportInvoiceList() {
        return importInvoiceList;
    }

    public void setImportInvoiceList(List<ImportInvoice> importInvoiceList) {
        this.importInvoiceList = importInvoiceList;
    }
}
