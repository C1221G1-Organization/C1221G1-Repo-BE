package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeServicee;


    /**
     * This method to get value from table
     * @return
     */

    @GetMapping(value = "/list")
    public ResponseEntity<List<AccountEmployee>> getListAccount() {
        List<AccountEmployee> accountEmployees = this.iEmployeeServicee.findAllAccount();
        if (accountEmployees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountEmployees, HttpStatus.OK);
    }
















}
