package com.c1221g1.pharmacy.dto.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;

import java.util.List;

public class PaymentDto {
    private Integer paymentId;
    private Integer paymentDiscount;
    private Double paymentPrepayment;

    public PaymentDto() {
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

}
