package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.employee.AccountEmployeeDto;
import com.c1221g1.pharmacy.dto.employee.IAccountEmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;



}
