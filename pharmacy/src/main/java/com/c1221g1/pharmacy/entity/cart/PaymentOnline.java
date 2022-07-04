package com.c1221g1.pharmacy.entity.cart;

import javax.persistence.*;

@Entity
public class PaymentOnline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Float discount;
    @JoinColumn(columnDefinition = "DATETIME")
    private String timeCreate;
    private String note;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId",nullable = false)
    private Cart cart;

    public PaymentOnline() {
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