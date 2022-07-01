package com.c1221g1.pharmacy.dto.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CartDetailDto implements Validator {
//    private Integer cartDetailId;
    private Integer cartDetailQuantity;
    private Medicine medicine;
    private Cart cart;

    public CartDetailDto() {
    }

    public Integer getCartDetailQuantity() {
        return cartDetailQuantity;
    }

    public void setCartDetailQuantity(Integer cartDetailQuantity) {
        this.cartDetailQuantity = cartDetailQuantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CartDetailDto cartDetailDto = (CartDetailDto) target;

    }
}
