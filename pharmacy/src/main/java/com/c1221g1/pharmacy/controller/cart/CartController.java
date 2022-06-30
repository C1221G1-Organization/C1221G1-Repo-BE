package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.service.cart.ICartDetailService;
import com.c1221g1.pharmacy.service.cart.ICartService;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private ICartDetailService iCartDetailService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Update item in cart by customer id, item quantity in cart
     * if cart null: create new cart
     *
     * @param cartDetailDto
     * @param bindingResult
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable String id,
                                        @Validated @RequestBody CartDetailDto cartDetailDto,
                                        BindingResult bindingResult) {
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        new CartDetailDto().validate(cartDetailDto, bindingResult);
        this.iCartDetailService.checkExistOfLinksObject(cartDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        CartDetail cartDetail = new CartDetail();
        BeanUtils.copyProperties(cartDetailDto, cartDetail);
        this.iCartDetailService.updateItemCartDetail(cartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: find cart by customer by id (check customer have cart before)
     * if cart null: create new cart and return cart to client.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findCartByCustomerId(@PathVariable String id) {
        Map<String, Object> cartResponse = new HashMap<>();
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            Cart newCart = new Cart();
            Cart cartReturn = this.iCartService.save(newCart, id);
            cartResponse.put("cart", cartReturn);
            cartResponse.put("totalItems", 0);
            //create new cart for this customer.
            return new ResponseEntity<>(cartResponse, HttpStatus.OK);
        }
        Integer totalItems = this.iCartService.countItemInCart(id);
        cartResponse.put("cart", cart);
        cartResponse.put("totalItems", totalItems);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
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
