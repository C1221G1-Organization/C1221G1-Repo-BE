package com.c1221g1.pharmacy.controller.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;


@RestController
@CrossOrigin()
@RequestMapping("/api/manager-customer/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    /**
     * create by TinBQ
     * time: 29/06/2022
     * This method to get data from table customer have paging, searching and sorting follow field "customerId",
     *"customerName", "customerAddress", "customerPhone", "customerType"
     */

    @GetMapping("")
    public ResponseEntity<Page<Customer>> getSearchAndSortCustomer(
            @RequestParam Optional<String> customerId,
            @RequestParam Optional<String> customerType,
            @RequestParam Optional<String> customerName,
            @RequestParam Optional<String> customerAddress,
            @RequestParam Optional<String> customerPhone,
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "3") int size,
            Pageable pageable){

        String valueCustomerId = customerId.orElse("");
        String valueCustomerType = customerType.orElse("");
        String valueCustomerName = customerName.orElse("");
        String valueCustomerAddress = customerAddress.orElse("");
        String valueCustomerPhone = customerPhone.orElse("");

         Page<Customer> customerPage =  iCustomerService.findAllCustomer(pageable,valueCustomerId,valueCustomerName,valueCustomerAddress,valueCustomerPhone,valueCustomerType);
        if (!customerPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * create by TinBQ
     * time: 29/06/2022
     * This method to set field flag in Database from 1 to 0
     */

    @PatchMapping("delete-customer/{customer_id}")
    public ResponseEntity<Customer> deleteMedicine(@PathVariable("customer_id") String id) {
        try {
            this.iCustomerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
