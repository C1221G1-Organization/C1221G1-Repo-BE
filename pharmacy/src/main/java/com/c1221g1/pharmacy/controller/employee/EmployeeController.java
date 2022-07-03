package com.c1221g1.pharmacy.controller.employee;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping(value = "api/manager-employee/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;

    @Autowired
    IUsersService iUsersService;


    /*
      Created by TamNA
      Time: 5:50:00 29/06/2022
      Function:  Create Employee
 */
    @PostMapping(value = "")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                            BindingResult bindingResult) {

        Map<String, String> errorMap = new HashMap<>();
//        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(
                            err -> errorMap.put(err.getField(), err.getDefaultMessage())
                    );
        }
        Employee employee = new Employee();
        Position position = new Position();
        employee.setPosition(position);
        position.setPositionId(employeeDto.getPosition().getPositionId());
        Users users = new Users();
        users.setUsername(employeeDto.getEmployeeUsername().getUsername());
        if (this.iUsersService.checkEmail(employeeDto.getEmployeeUsername().getUsername()).size() > 0) {
            errorMap.put("usersName", "Tên đăng nhập đã trùng");
            return ResponseEntity.badRequest().body(new ResponseMessage(false, "Failed!", errorMap, new ArrayList<>()));
        }
        users.setFlag(true);
        users.setPassword("12345");
        this.iUsersService.saveUser(users);
        employee.setEmployeeUsername(users);
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
      Created by TamNA
      Time: 9:50:00 29/06/2022
      Function:  Update Employee
 */
    @PatchMapping(value = "{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id,
                                            @Valid @RequestBody EmployeeDto employeeDto,
                                            BindingResult bindingResult) {
        Employee employeeById = this.iEmployeeService.findEmployeeById(id);
        employeeDto.validate(employeeDto, bindingResult);
        if (employeeById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Map<String, String> errorMap = new HashMap<>();
//        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .forEach(
                            err -> errorMap.put(err.getField(), err.getDefaultMessage())
                    );
        }
        Employee employee = new Employee();
        Position position = new Position();

        employee.setPosition(position);
        position.setPositionId(employeeDto.getPosition().getPositionId());
        Users users = new Users();
        users.setUsername(employeeDto.getEmployeeUsername().getUsername());
        users.setFlag(true);
        users.setPassword("12345");
        this.iUsersService.saveUser(users);
        employee.setEmployeeUsername(users);
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
      Created by TamNA
      Time: 11:50:00 03/07/2022
      Function:  FindById Employee
 */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String id) {
        Employee employee = this.iEmployeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * this function use to get all page Employee
     *
     * @author GiangTB
     * @Time 15:30 29/06/2022
     */
    @GetMapping(value = "")
    public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam Optional<String> employeeId,
                                                         @RequestParam Optional<String> employeeName,
                                                         @RequestParam Optional<String> position,
                                                         @RequestParam Optional<String> employeeAddress,
                                                         @RequestParam Optional<String> employeePhone,
                                                         @RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "5") Integer size,
                                                         @RequestParam(defaultValue = "employee_id") Optional<String> sort) {
        String employeeIdVal = employeeId.orElse("");
        String employeeNameVal = employeeName.orElse("");
        String positionVal = position.orElse("");
        String employeeAddressVal = employeeAddress.orElse("");
        String employeePhoneVal = employeePhone.orElse("");
        String sortBy = sort.orElse("employee_id");
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> employeePage =
                this.iEmployeeService.getAllEmployee(employeeIdVal,
                        employeeNameVal, positionVal, employeeAddressVal, employeePhoneVal, pageable);
        if (!employeePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:00 29/06/2022
     */
    @GetMapping(value = "/list")
    public ResponseEntity<List<Employee>> getList() {
        List<Employee> employeeList = this.iEmployeeService.getListEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    /**
     * this function use to delete employee from page (not delete in database)
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable String id) {
        Employee employee = this.iEmployeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
