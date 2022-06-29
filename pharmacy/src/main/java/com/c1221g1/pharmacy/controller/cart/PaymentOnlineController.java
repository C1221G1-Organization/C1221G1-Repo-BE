package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("**")
@RequestMapping("/api/lookup/payment-online")
public class PaymentOnlineController {
    @Autowired
    private IPaymentOnlineService iPaymentOnlineService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Receive request from client with method get. Find payment online mapping with optional condition search.
     * return all payment online in database if have no optional search key.
     * @param paymentOnlineId
     * @param customerName
     * @param page
     * @param size
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Page<PaymentOnline>> getPaymentOnline(@RequestParam Optional<String> paymentOnlineId,
                                                                @RequestParam Optional<String> customerName,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "5") int size) {
        String paymentOnlineIdVal = paymentOnlineId.orElse("");
        String customerNameVal = customerName.orElse("");
        Pageable pageable = PageRequest.of(page, size);
        Page<PaymentOnline> paymentOnlines = this.iPaymentOnlineService.findAll(paymentOnlineIdVal, customerNameVal, pageable);
        if (paymentOnlines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentOnlines, HttpStatus.OK);
    }
}
