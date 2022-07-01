package com.c1221g1.pharmacy.controller.employee;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
                                                         @RequestParam(defaultValue = "employee_id") Optional<String> sort){
        String employeeIdVal= employeeId.orElse("");
        String employeeNameVal= employeeName.orElse("");
        String positionVal= position.orElse("");
        String employeeAddressVal= employeeAddress.orElse("");
        String employeePhoneVal= employeePhone.orElse("");
        String sortBy= sort.orElse("employee_id");
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        Page<Employee> employeePage =
                this.iEmployeeService.getAllEmployee(employeeIdVal,
                        employeeNameVal,positionVal,employeeAddressVal,employeePhoneVal,pageable);
        if(!employeePage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage,HttpStatus.OK);
    }

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:00 29/06/2022
     */
    @GetMapping(value = "/list")
    public ResponseEntity<List<Employee>> getList(){
        List<Employee> employeeList = this.iEmployeeService.getListEmployee();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    /**
     * this function use to delete employee from page (not delete in database)
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable String id){
        Employee employee = this.iEmployeeService.findEmployeeById(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
