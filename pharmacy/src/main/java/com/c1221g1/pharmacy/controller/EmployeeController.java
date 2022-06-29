package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeServicee;


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     *
     */
    @GetMapping(value = "/listAccount")
    public ResponseEntity<List<AccountEmployee>> getListAccount() {
        List<AccountEmployee> accountEmployees = this.iEmployeeServicee.findAllAccount();
        if (accountEmployees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountEmployees, HttpStatus.OK);
    }


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     *
     */
    @GetMapping(value = "/listAccountPage")
    public ResponseEntity<Page<AccountEmployee>> getListAccount2(
            @PageableDefault(value = 4) Pageable pageable,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> idEmployee,
            @RequestParam Optional<String> position,
            @RequestParam Optional<String> userName
            ) {
        String nameVal = name.orElse("");
        String idEmployeeVal = idEmployee.orElse("");
        String positionVal = position.orElse("");
        String userNameVal = userName.orElse("");
        Page<AccountEmployee> accountEmployeePage =
                this.iEmployeeServicee.findAccount(nameVal, idEmployeeVal, positionVal, userNameVal, pageable);
        if (!accountEmployeePage.hasContent()) {
            return new ResponseEntity<>(accountEmployeePage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountEmployeePage, HttpStatus.OK);
    }




}
