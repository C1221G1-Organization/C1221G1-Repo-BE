package com.c1221g1.pharmacy.controller.employee;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    /*
      Created by TamNA
      Time: 5:50:00 29/06/2022
      Function:  Create Employee
 */
    @PostMapping(value = "")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
      Created by TamNA
      Time: 9:50:00 29/06/2022
      Function:  Update Employee
 */
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id,
                                                   @Valid @RequestBody EmployeeDto employeeDto,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
