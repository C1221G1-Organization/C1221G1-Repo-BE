package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "/customerType")
    public ResponseEntity<List<CustomerType>> getCustomerType() {
        List<CustomerType> customerTypes = this.iCustomerTypeService.findAllCustomerType();
        if (customerTypes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerTypes, HttpStatus.OK);
    }
}
