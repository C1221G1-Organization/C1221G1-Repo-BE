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


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    @GetMapping(value = "/listAccount")
    public ResponseEntity<List<IAccountEmployeeDto>> getListAccount() {
        List<IAccountEmployeeDto> accountEmployees = this.iEmployeeService.findAllAccount();
        if (accountEmployees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountEmployees, HttpStatus.OK);
    }


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @GetMapping(value = "/listAccountPage")
    public ResponseEntity<Page<IAccountEmployeeDto>> getListAccountPage(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> id,
            @RequestParam Optional<String> username,
            @RequestParam Optional<Integer> position
    ) {

        String nameVal = name.orElse("");
        String idVal = id.orElse("");
        String usernameVal = username.orElse("");
        int positionVal = position.orElse(-1);
        Page<IAccountEmployeeDto> iAccountEmployeeDtoPage = null;

        if (positionVal == -1) {
            iAccountEmployeeDtoPage = iEmployeeService.findAndSearchAccount2(idVal, nameVal, usernameVal, pageable);
            if (iAccountEmployeeDtoPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(iAccountEmployeeDtoPage, HttpStatus.OK);
            }
        } else {
            iAccountEmployeeDtoPage = iEmployeeService.findAndSearchAccount(idVal, nameVal, positionVal, usernameVal, pageable);
            if (iAccountEmployeeDtoPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(iAccountEmployeeDtoPage, HttpStatus.OK);
            }
        }
    }

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    @GetMapping(value = "/findAccount/{id}")
    public ResponseEntity<IAccountEmployeeDto> findId(@PathVariable("id") String id) {
        IAccountEmployeeDto accountEmployee = iEmployeeService.findAccountId(id);
        if (accountEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(accountEmployee, HttpStatus.OK);
    }

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    @PatchMapping(value = "updateAccount")
    public ResponseEntity<Object> updateAccount(
            @RequestParam String id,
            @RequestBody AccountEmployeeDto accountEmployeeDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        IAccountEmployeeDto iAccountEmployeeDto = iEmployeeService.findAccountId(id);
        if (iAccountEmployeeDto != null) {
            iEmployeeService.updateAccount(accountEmployeeDto.getPassword(), accountEmployeeDto.getPositionId(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
