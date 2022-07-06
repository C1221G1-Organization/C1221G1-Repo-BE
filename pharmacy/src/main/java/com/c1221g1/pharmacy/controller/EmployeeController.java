package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

}
