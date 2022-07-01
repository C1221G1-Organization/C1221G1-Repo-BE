package com.c1221g1.pharmacy.entity.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discount {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    private String discountId;
    private Double discountValue;

    @JsonBackReference(value = "cartList")
    @OneToMany(mappedBy = "discount")
    private List<Cart> cartList;

    public Discount() {
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
