package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.dto.cart.CartAndDetailDto;
import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.dto.cart.CartDtoForList;
import com.c1221g1.pharmacy.dto.cart.CustomerMailing;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.cart.ICartDetailService;
import com.c1221g1.pharmacy.service.cart.ICartService;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import com.c1221g1.pharmacy.service.cart.ISendingEmailService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICartDetailService iCartDetailService;

    @Autowired
    private IMedicineService iMedicineService;

    @Autowired
    private IPaymentOnlineService iPaymentOnlineService;
    @Autowired
    private ISendingEmailService iSendingEmailService;

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
     * Date created: 1/7/2022
     * function: Get list cart detail of customer by customer id
     *
     * @param id
     * @return
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getListDetail(@PathVariable String id) {
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<CartDtoForList> cartDetails = this.iCartDetailService.getListByCartId(cart.getCartId());
        if (cartDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
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
     * Date created: 4/7/2022
     * function: check cart and details send from client, and return to payment pay if cart valid (For user non-login)
     */
    @PostMapping("")
    public ResponseEntity<?> checkCartAndDetailFromClient(@RequestBody CartAndDetailDto cartAndDetailDto) {

        //Validate
        System.out.println(cartAndDetailDto);
        return new ResponseEntity<>(cartAndDetailDto, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 4/7/2022
     * function: save cart and detail after customer pay with paypal (For user non-login)
     */
    @PostMapping("/saveCart")
    public ResponseEntity<?> saveCartAndDetail(@RequestBody CartAndDetailDto cartAndDetailDto) {
        System.out.println(cartAndDetailDto);
        Cart cart = new Cart();
        if (cartAndDetailDto.getDiscount() != null) {
            cart.setDiscount(cartAndDetailDto.getDiscount());
        }
        cart = this.iCartService.save(cart, "KH-0001");
        this.iCartService.setCartComplete(cart.getCartId());
        System.out.println(cart);
        Double total = 0.0;
        for (CartDetailDto cartDetailDto : cartAndDetailDto.getCartDetail()) {
            total += cartDetailDto.getQuantity() * cartDetailDto.getMedicine().getMedicinePrice();
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartDetailQuantity(cartDetailDto.getQuantity());
            Medicine medicine = this.iMedicineService.findMedicineById(cartDetailDto.getMedicine().getMedicineId()).get();
            cartDetail.setMedicine(medicine);
            cartDetail.setCart(cart);
            this.iCartDetailService.save(cartDetail);
        }
        PaymentOnline paymentOnline = new PaymentOnline();
        paymentOnline.setCart(cart);
        this.iPaymentOnlineService.save(paymentOnline);
        CustomerMailing customerMailing = new CustomerMailing();
        customerMailing.setName(cartAndDetailDto.getCustomer().getCustomerName());
        customerMailing.setPhone(cartAndDetailDto.getCustomer().getCustomerPhone());
        customerMailing.setAddress(cartAndDetailDto.getCustomer().getCustomerAddress());
        customerMailing.setEmail(cartAndDetailDto.getCustomer().getCustomerUserName());
        customerMailing.setTotal(total);
        try{
            this.iSendingEmailService.sendEmail(customerMailing);
        }catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("success");
        return new ResponseEntity<>(HttpStatus.OK);
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
