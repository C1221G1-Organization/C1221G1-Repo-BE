package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("**")
@RequestMapping("/api/carts")
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
    public ResponseEntity<?> updateItem(@Validated @RequestBody CartDetailDto cartDetailDto, BindingResult bindingResult) {
        new CartDetailDto().validate(cartDetailDto, bindingResult);
        this.iCartService.checkExistOfLinksObject(cartDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Cart cart = this.iCartService.findCartByCustomerId(customer.getCustomerId());
        if (cart == null) {
            cart.setCustomer(customer);
            this.iCartService.save(cart);
        } else {

        }
    }

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: exception handle if validate have errors. Return bad request to client and error messages.
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
