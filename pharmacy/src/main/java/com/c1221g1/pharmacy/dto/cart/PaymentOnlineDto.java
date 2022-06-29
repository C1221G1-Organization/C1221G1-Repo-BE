package com.c1221g1.pharmacy.dto.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;

public class PaymentOnlineDto {
    private Integer paymentId;
    private Float discount;
    private String timeCreate;
    private String note;
    private Cart cart;

    public PaymentOnlineDto() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
