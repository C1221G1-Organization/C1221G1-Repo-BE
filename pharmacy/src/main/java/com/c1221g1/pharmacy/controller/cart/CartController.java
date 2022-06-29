package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("**")
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: Update item, item quantity in cart
     * if cart null: create new cart
     *
     * @param customer
     * @param medicine
     * @param quantity
     * @return
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody Customer customer,
                                        @RequestBody Medicine medicine,
                                        @RequestBody int quantity) {
        Cart cart = this.iCartService.findCartByCustomerId(customer.getCustomerId());
        if (cart == null) {
            this.iCartService.save(customer);
        } else {

        }
    }
}
