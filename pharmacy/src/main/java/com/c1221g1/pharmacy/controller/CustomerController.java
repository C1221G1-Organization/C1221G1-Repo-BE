package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager_customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    /**
     * Create by TruongNQ
     * Time : 20:20 29/06/2022
     * Function create customer
     */
    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createCustomer(@Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Create by TruongNQ
     * Time : 20:21 29/06/2022
     * Function get customer by id
     */
    @GetMapping(value = "/findByCustomerId")
    public ResponseEntity<Customer> findCustomerById(@RequestParam String customerId) {
        Customer customer = iCustomerService.findByCustomerId(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    /**
     * Create by TruongNQ
     * Time : 20:22 29/06/2022
     * Function update customer by id
     */
    @PatchMapping(value = "/edit/{customerId}")
    public ResponseEntity<List<FieldError>> updateCustomer(@PathVariable String customerId, @Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customerOptional = Optional.ofNullable(iCustomerService.findByCustomerId(customerId));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDto.setCustomerId(customerOptional.get().getCustomerId());
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
